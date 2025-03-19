package pe.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.account.AccountDAO;
import pe.account.AccountDTO;
import pe.employee.EmployeeDAO;
import pe.employee.EmployeeDTO;

public class MainController extends HttpServlet {
    
    private static final String ERROR = "error.jsp";
    private static final String EMPLOYEES = "employees.jsp";
    private static final String CREATE = "create.jsp";
    private static final String LOGIN = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //your code here
            String action = request.getParameter("action");
            
            switch (action) {
                case "login":
                    url = login(request, response);
                    break;
                case "logout":
                    url = logout(request, response);
                    break;
                case "search":
                    url = search(request, response);
                    break;
                case "create":
                    url = create(request, response);
                    break;
                case "create_handler":
                    url = create_handler(request, response);
                    break;
                case "remove":
                    url = remove(request, response);
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", e.toString());
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    
    protected String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            
            AccountDAO ad = new AccountDAO();
            AccountDTO ac = ad.login(email, password);
            
            HttpSession session = request.getSession();
            
            if (ac != null) {
                session.setAttribute("account", ac);
                employeeList(request, response);
                return EMPLOYEES;
            } else {
                request.setAttribute("message", "Incorrect email or password");
            }
            
        } catch (Exception ex) {
            request.setAttribute("message", "Incorrect email or password");
        }
        
        return LOGIN;
    }
    
    protected void employeeList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeDAO ed = new EmployeeDAO();
            List<EmployeeDTO> list = ed.selectAll();
            
            request.setAttribute("list", list);
            
        } catch (Exception ex) {
            request.setAttribute("message", "Error reading list");
        }
    }
    
    protected String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        session.invalidate();
        
        return LOGIN;
    }
    
    protected String search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String fullName = request.getParameter("fullName").trim();
            
            EmployeeDAO ed = new EmployeeDAO();
            List<EmployeeDTO> list = ed.search(fullName);
            
            request.setAttribute("list", list);
            
        } catch (Exception ex) {
            request.setAttribute("message", "Error searching");
        }
        
        return EMPLOYEES;
    }
    
    protected String create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        AccountDTO acc = (AccountDTO) session.getAttribute("account");
        
        if (acc.getRoleId().equalsIgnoreCase("AM")) {
            return CREATE;
        } else {
            return LOGIN;
        }
    }
    
    protected String create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String fullName = request.getParameter("fullName").trim();
                    String sdob = request.getParameter("dob");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dob = sdf.parse(sdob);
                    double salary = Double.parseDouble(request.getParameter("salary"));
                    
                    if(fullName.isEmpty()) {
                        request.setAttribute("message", "Empty name");
                        return EMPLOYEES;
                    }
                    
                    if(sdob.isEmpty()) {
                        request.setAttribute("message", "Empty date");
                        return EMPLOYEES;
                    }
                    
                    EmployeeDAO ed = new EmployeeDAO();
                    ed.create(new EmployeeDTO(fullName, dob, salary));
                
                case "cancel":
                    employeeList(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Error creating employee");
            ex.printStackTrace();
        }
        
        return EMPLOYEES;
    }
    
    protected String remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            
            EmployeeDAO ed = new EmployeeDAO();
            ed.remove(id);
            
            employeeList(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("message", "Error removing employee");
        }
        
        return EMPLOYEES;
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
