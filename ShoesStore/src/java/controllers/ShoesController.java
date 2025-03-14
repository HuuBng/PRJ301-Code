package controllers;

import db.Shoes;
import db.ShoesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShoesController", urlPatterns = {"/shoes"})
public class ShoesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "detail":
                detail(request, response);
                break;
            case "brand":
                brandFilter(request, response);
                break;
            case "price":
                priceFilter(request, response);
                break;
            case "search":
                search(request, response);
                break;

        }
    }
    
    private Integer getPage(HttpServletRequest request, HttpServletResponse response) {
        Integer page = (Integer) request.getAttribute("page");
            if (page == null) {
                page = 1;
                request.setAttribute("page", page);
            }

            String spage = request.getParameter("page");
            if (spage != null) {
                page = Integer.parseInt(spage);

                // Luu page vao request
                request.setAttribute("page", page);
            }
            return page;
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 6;
            // Lay tham so page

            HttpSession session = request.getSession();

            Integer page = getPage(request, response);

            //doc table toy
            ShoesFacade pf = new ShoesFacade();
            List<Shoes> list = pf.select(page, pageSize);

            // Luu totalPage vao request
            int totalPage = (int) Math.ceil(pf.count() * 1.0 / pageSize);
            request.setAttribute("totalPage", totalPage);

            //luu list vao request
            request.setAttribute("list", list);

            //forward request va response cho view 
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void detail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            ShoesFacade sf = new ShoesFacade();
            Shoes shoes = sf.read(id);

            String tmp = shoes.getSize().replace("[", "").replace("]", "").replace(" ", "").trim();
            List<String> sizeList = Arrays.asList(tmp.split(","));

            request.setAttribute("shoes", shoes);
            request.setAttribute("sizeList", sizeList);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't show shoe details");
            request.getRequestDispatcher("/shoes/index.do").forward(request, response);
        }

    }

    protected void brandFilter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int pageSize = 6;
            // Lay tham so page

            Integer page = getPage(request, response);

            String brand = request.getParameter("brand");
            ShoesFacade sf = new ShoesFacade();
            List<Shoes> list = sf.getByBrand(brand, page, pageSize);

            // Luu totalPage vao request
            int totalPage = (int) Math.ceil(sf.countByBrand(brand) * 1.0 / pageSize);
            request.setAttribute("totalPage", totalPage);

            // Luu brand vao request
            request.setAttribute("brand", brand);

            request.setAttribute("shoesList", list);  // Đảm bảo key là shoesList
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void priceFilter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();

            // Lay page
            int pageSize = 6;
            // Lay tham so page

            Integer page = getPage(request, response);

            // Lay price range
            int min_price;
            int max_price;

            min_price = Integer.parseInt(request.getParameter("min_price"));
            max_price = Integer.parseInt(request.getParameter("max_price"));

            // Check price range
            if (min_price < 0) {
                min_price = 0;
            }

            if (max_price < 0) {
                max_price = 1000000;
            }

            if (min_price > max_price) {
                int t = min_price;
                min_price = max_price;
                max_price = t;
            }

            String order;
            try {
                order = request.getParameter("orderBy").trim().toUpperCase();
                if (!order.equals("DESC") && !order.equals("ASC")) {
                    order = "DESC";
                }
            } catch (Exception ex) {
                order = "DESC";
            }

            // Lay list
            ShoesFacade sf = new ShoesFacade();
            List<Shoes> list = sf.getByPrice(order, min_price, max_price, page, pageSize);

            // Luu totalPage vao request
            int totalPage = (int) Math.ceil(sf.countByPrice(min_price, max_price) * 1.0 / pageSize);
            request.setAttribute("totalPage", totalPage);
            
            if(totalPage == 0) {
                request.setAttribute("page", 0);
            }

            request.setAttribute("min_price", min_price);
            request.setAttribute("max_price", max_price);
            request.setAttribute("orderBy", order);
            // Luu list
            request.setAttribute("sortedList", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 6;
            // Lay tham so page

            Integer page = getPage(request, response);

            String keyword = request.getParameter("keyword");
            ShoesFacade sf = new ShoesFacade();
            List<Shoes> list = sf.searchByKeyword(keyword, page, pageSize);

            int totalPage = (int) Math.ceil(sf.countBySearch(keyword) * 1.0 / pageSize);
            request.setAttribute("totalPage", totalPage);

            request.setAttribute("keyword", keyword);

            request.setAttribute("searchResults", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
