package controllers;

import db.Shoes;
import db.ShoesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            case "create":
                create(request, response);
                break;
            case "create_handler":
                create_handler(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "delete_handler":
                delete_handler(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "edit_handler":
                edit_handler(request, response);
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

            //doc table shoes
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
            int id = Integer.parseInt(request.getParameter("id"));
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

            if (totalPage == 0) {
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

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ShoesFacade sf = new ShoesFacade();
            List<Shoes> list = sf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    //lay thong tin tu user
                    String name = request.getParameter("name").trim();
                    String brand = request.getParameter("brand").trim();
                    String category = request.getParameter("category").trim();
                    String size = request.getParameter("size").replace(".", ",").replace(" ", "");
                    int price = Integer.parseInt(request.getParameter("price"));
                    Double discount = Double.parseDouble(request.getParameter("discount"));
                    // tao doi tuong shoes
                    Shoes shoes = new Shoes();
                    if (!name.isEmpty()) {
                        shoes.setName(name);
                    }
                    if (!brand.isEmpty()) {
                        shoes.setBrand(brand);
                    }
                    if (!category.isEmpty()) {
                        shoes.setCategory(category);
                    }

                    // Input and sort shoes size
                    // Use a List to hold the integer values
                    List<Integer> sizeList = new ArrayList<>();

                    if (size != null && !size.trim().isEmpty()) {
                        String[] sizeArray = size.split(",");
                        for (String sa : sizeArray) {
                            sa = sa.trim();
                            // Check that the string is not empty and contains only digits (i.e., positive numbers)
                            if (!sa.isEmpty() && sa.matches("\\d+")) {
                                // Parse and add the number to the list
                                sizeList.add(Integer.parseInt(sa));
                            }
                        }
                    }

                    // If there are valid numbers, sort them and build the output string
                    if (!sizeList.isEmpty()) {
                        // Sort the list in ascending order
                        Collections.sort(sizeList);

                        // Build the output string in the format [number1,number2,...]
                        StringBuilder sizeBuilder = new StringBuilder();
                        for (int i = 0; i < sizeList.size(); i++) {
                            if (i > 0) {
                                sizeBuilder.append(",");
                            }
                            sizeBuilder.append(sizeList.get(i));
                        }
                        // Set the sorted size string with enclosing square brackets
                        shoes.setSize("[" + sizeBuilder.toString() + "]");
                    }

                    if (price > 0) {
                        shoes.setPrice(price);
                    }
                    if (discount > 0 && discount < 100) {
                        shoes.setDiscount(discount / 100);
                    }

                    //insert data
                    ShoesFacade sf = new ShoesFacade();
                    sf.create(shoes);
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
                case "cancel":
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Khong duoc bo trong hoac size, price va discount phai la so duong");
            request.getRequestDispatcher("/shoes/create.do").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "yes":
                    int id = Integer.parseInt(request.getParameter("id"));
                    ShoesFacade sf = new ShoesFacade();
                    sf.delete(id);
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
                case "no":
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ShoesFacade sf = new ShoesFacade();
            Shoes shoes = sf.read(id);
            shoes.setSize(shoes.getSize().replaceAll("[\\[\\]\\s]", ""));
            //luu shoes vao request truyen cho view
            request.setAttribute("shoes", shoes);
            List<Shoes> list = sf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "update":
                    int id = Integer.parseInt(request.getParameter("id").trim());
                    String name = request.getParameter("name").trim();
                    String brand = request.getParameter("brand").trim();
                    String category = request.getParameter("category").trim();
                    String size = request.getParameter("size").replaceAll("[\\[\\]\\s]", "").replace(".", ",");
                    int price = Integer.parseInt(request.getParameter("price"));
                    Double discount = Double.parseDouble(request.getParameter("discount"));
                    // tao doi tuong shoes
                    Shoes shoes = new Shoes();
                    shoes.setId(id);
                    if (!name.isEmpty()) {
                        shoes.setName(name);
                    }
                    if (!brand.isEmpty()) {
                        shoes.setBrand(brand);
                    }
                    if (!category.isEmpty()) {
                        shoes.setCategory(category);
                    }
                    
                    // Input and sort shoes size
                    // Use a List to hold the integer values
                    List<Integer> sizeList = new ArrayList<>();

                    if (size != null && !size.trim().isEmpty()) {
                        String[] sizeArray = size.split(",");
                        for (String sa : sizeArray) {
                            sa = sa.trim();
                            // Check that the string is not empty and contains only digits (i.e., positive numbers)
                            if (!sa.isEmpty() && sa.matches("\\d+")) {
                                // Parse and add the number to the list
                                sizeList.add(Integer.parseInt(sa));
                            }
                        }
                    }

                    // If there are valid numbers, sort them and build the output string
                    if (!sizeList.isEmpty()) {
                        // Sort the list in ascending order
                        Collections.sort(sizeList);

                        // Build the output string in the format [number1,number2,...]
                        StringBuilder sizeBuilder = new StringBuilder();
                        for (int i = 0; i < sizeList.size(); i++) {
                            if (i > 0) {
                                sizeBuilder.append(",");
                            }
                            sizeBuilder.append(sizeList.get(i));
                        }
                        // Set the sorted size string with enclosing square brackets
                        shoes.setSize("[" + sizeBuilder.toString() + "]");
                    }

                    if (price > 0) {
                        shoes.setPrice(price);
                    }
                    if (discount > 0 && discount < 100) {
                        shoes.setDiscount(discount / 100);
                    }
                    //update data
                    ShoesFacade sf = new ShoesFacade();
                    sf.update(shoes);
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
                case "cancel":
                    request.getRequestDispatcher("/").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Khong duoc bo trong hoac size, price va discount phai la so duong");
            //cho hien lai view edit
            edit(request, response);
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
