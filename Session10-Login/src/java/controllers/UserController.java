package controllers;

import db.Account;
import db.AccountFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserController", urlPatterns = {"/user/*"})
public class UserController extends HttpServlet {

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

        //System.out.println("action: " + action)
        switch (action) {
            case "index":
                login(request, response);
                break;
        }

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    AccountFacade af = new AccountFacade();
                    Account acc = af.login(email, password);

                    if (acc != null) {
                        // If login dung

                        // Lay tham chieu cua doi tuong session
                        HttpSession session = request.getSession();

                        // luu account vao session
                        session.setAttribute("account", acc);

                        // Forward den role tuong ung cua user
                        if (acc.getRole().equalsIgnoreCase("ADMIN")) {
                            request.getRequestDispatcher("/admin.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("/user.jsp").forward(request, response);
                        }
                    } else {
                        // If login sai
                        request.setAttribute("message", "Please check your email and password!!!");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }

                    break;
                case "cancel":
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);

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
