package controllers;

import db.Toy;
import db.ToyFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToyController extends HttpServlet {

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
        String action = request.getParameter("action");
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                // Hien form
                create(request, response);
                break;
            case "create_handler":
                // Xu ly form
                create_handler(request, response);
                break;
            case "delete":
                // Hien form
                delete(request, response);
                break;
            case "delete_handler":
                // Xu ly form
                delete_handler(request, response);
                break;
        }

    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //doc table toy
            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
            //luu list vao request
            request.setAttribute("list", list);
            //forward request va response cho view 
            request.getRequestDispatcher("/toy.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/create.jsp").forward(request, response);
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
                    String brand = request.getParameter("brand");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "toy"
                    Toy toy = new Toy(id, name, price, sdf.parse(expDate), brand);
                    // insert data vao db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
//                    break;
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/toy?action=index").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't add new toy");
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "toy"
                    Toy toy = new Toy(id, name, price, sdf.parse(expDate), brand);
                    // insert data vao db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
//                    break;
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/toy?action=index").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't add new toy");
            request.getRequestDispatcher("/create.jsp").forward(request, response);
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
