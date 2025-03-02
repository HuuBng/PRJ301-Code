/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.car.CarDAO;
import pe.car.CarDTO;
import pe.user.UserDAO;
import pe.user.UserDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = ERROR;
            try {
//                your code here
                String action = request.getParameter("action");
                System.out.println("action: " + action);
                switch (action) {
                    case "login":
                        login(request, response);
                        break;
                    case "logout":
                        logout(request, response);
                        break;
                    case "create":
                        create(request, response);
                        break;
                }

            } catch (Exception e) {
                log("Error at MainController: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userID = request.getParameter("userid");
        String password = request.getParameter("password");

        try {
            UserDAO uf = new UserDAO();
            UserDTO user = uf.login(userID, password);

            if (user != null) {
                session.setAttribute("user", user);
                carList(request, response);

                request.getRequestDispatcher("carList.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Incorrect UserID or Password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Incorrect UserID or Password");
        }
    }

    protected void carList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            CarDAO cf = new CarDAO();
            List<CarDTO> list = cf.list();

            if (list != null) {
                session.setAttribute("list", list);
            } else {
                throw new Exception();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Error reading car list");
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.invalidate();

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<CarDTO> list = (List<CarDTO>) session.getAttribute("list");

        String id = String.format("C-%03d", Integer.parseInt(request.getParameter("id")));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int speed = Integer.parseInt(request.getParameter("speed"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        String message = null;

        if (id == null) {
            message = "id can not be null";

        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    message = "id is already in database";
                }
            }
        }

        if (name.isEmpty()) {
            message = "Name can not be null";
        }

        if (description.isEmpty()) {
            message = "Description can not be null";
        }

        if (message != null) {
            request.setAttribute("message", message);
            request.getRequestDispatcher("carList.jsp").forward(request, response);
        }

        try {
            CarDAO cf = new CarDAO();
            cf.create(id, name, description, price, speed, status);
            request.setAttribute("message", "Create successfully");
            carList(request, response);
            request.getRequestDispatcher("carList.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Error creating car");
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
