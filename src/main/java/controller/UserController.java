/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Uso los metodos de user DAO para procesar lo que pide el usuario a través de las vistas
 
package controller;

import database.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;
import java.util.*;

/**
 *
 * @author pato
 */
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
        try (PrintWriter out = response.getWriter()) {
           
            String action = request.getPathInfo();
            HttpSession session = request.getSession();
            UserDAO userDB = new UserDAO(); // instancia de userDAO que abre la conexión
          
            switch (action) {
                case "/login":
                
                String uName = request.getParameter("user");
                String passw = request.getParameter("password");
                boolean loggedIn = userDB.login (uName, passw); // consulta a la base de datos
                
                if (loggedIn) {
                    User userL = userDB.getUserByUserName(uName);
                    session.setAttribute("isLogin", loggedIn);
                    session.setAttribute("userLogged", userL);
                    
                    response.sendRedirect("/views/profile.jsp");
                } else {
//                    JFrame jFrame = new JFrame();
//                    JOptionPane.showMessageDialog(jFrame,"Error en los datos ingresados.");
                    response.sendRedirect("/views/login.jsp");
                }
                    break;
 
                case "/createUser":
                    uName = request.getParameter("username");
                    passw = request.getParameter("password");
                    String name = request.getParameter("name");
                    String lastname = request.getParameter("lastname");
                    String gender = request.getParameter("gender");
                    String email = request.getParameter("email");
                    String city = request.getParameter("city");
                    String country = request.getParameter("country");
                    String repassw = request.getParameter("repassword");
                    
                    UserDAO userDBA = new UserDAO();
                    
                    boolean isCreated = userDBA.createUser(uName, passw, name, lastname, gender, email, city, country, repassw);
                    
                    if (isCreated) {
                        session.setAttribute("createMessage", isCreated);
                        response.sendRedirect("/views/userNewMssg.jsp"); 
                         
                    } else {
                        session.setAttribute("createMessage", isCreated);
                        response.sendRedirect("/views/userNewMssg.jsp");
                    }
                    break;
                
                case "/profile":
                    response.sendRedirect("/views/profile.jsp");   
                    break;
             
                case "/logout":
                    session.setAttribute("isLogin", false);
                    response.sendRedirect("/");   
                    break;
                
                
                case "/delete":
                  int userID = Integer.parseInt(session.getAttribute("ID").toString());
                  boolean isDeleted = userDB.deleteUser(userID);
                    
                    if (isDeleted) {
                        session.setAttribute("deleteMssg", isDeleted);
                        session.setAttribute("isLogin", false);
                        response.sendRedirect("/views/userDelMssg.jsp");
                    } else {
                        session.setAttribute("deleteMssg", isDeleted);
                        response.sendRedirect("/views/userDelMssg.jsp");
                    }
                    break;
                    
//                case "/updateUser":
//                    userName = request.getParameter("username");
//                    passw = request.getParameter("password");
//                    email = request.getParameter("email");
//                    city = request.getParameter("city");
//                    country = request.getParameter("country");
//                    repassw = request.getParameter("repassword");
//                    
//                    UserDAO userUpd = new UserDAO();
//                    
//                    boolean isUpdated = userUpd.modifyUser(userName, passw, email, city, country, repassw);
//                    
//                   
//                    if (isUpdated) {
//                        session.setAttribute("createMessageCr", isUpdated);
//                        response.sendRedirect("/views/userMessage.jsp"); 
//                         
//                    } else {
//                        session.setAttribute("createMessageCr", isUpdated);
//                        response.sendRedirect("/views/userMessage.jsp");
//                    }
//                    break;
                    
                default:
                    
                    break;
                
            }                   
        } catch (SQLException err) {
            err.printStackTrace();          
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

