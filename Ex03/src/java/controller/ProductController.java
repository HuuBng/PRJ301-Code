package controller;

import db.Product;
import db.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductController", urlPatterns = {"/product/*"})
public class ProductController extends HttpServlet {

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
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
        switch (action) {
            case "index":
                index(request, response);
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

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductFacade pf = new ProductFacade();
            List<Product> list = pf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/create-product.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "product"
                    Product product = new Product(id, name, price, sdf.parse(expDate));
                    // insert data vao db
                    ProductFacade pf = new ProductFacade();
                    pf.create(product);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/product/index.do").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't add new product");
            request.getRequestDispatcher("/create-product.jsp").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/delete-product.jsp").forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "yes":
                    String id = request.getParameter("id");
                    ProductFacade pf = new ProductFacade();
                    pf.delete(id);
                case "no":
                    // Cho hien danh sach product, chay lai case index
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/product/index.do").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            ProductFacade pf = new ProductFacade();
            Product product = pf.read(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/edit-product.jsp").forward(request, response);

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
                    // Lay thong tin tu client
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "product"
                    Product product = new Product(id, name, price, sdf.parse(expDate));
                    // update
                    ProductFacade pf = new ProductFacade();
                    pf.update(product);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/product/index.do").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't edit product");
//            edit(request, response);
            request.getRequestDispatcher("/product/index.do").forward(request, response);

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
