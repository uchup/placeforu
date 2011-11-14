/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import entity.User;
import entity.DaftarUser;
import jpa.UserJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Widiasa
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");

        DaftarUser daftarUser = new DaftarUser();
        User users = daftarUser.getUser(name,pass);
        if (users != null) {
            if (users.getUsername().equals(name) && users.getPassword().equals(pass) ) {
                session.setAttribute("sessionusername", name);
                dis = request.getRequestDispatcher("home.jsp");
                dis.forward(request, response);
            }
            else {
                out.println("Password Invalid");
            }
        }
        else {
            dis = request.getRequestDispatcher("gagallogin.jsp");
            dis.forward(request, response);
        }
    }
        /*User user = daftarUser.getUser(name,pass);

        String username = user.getUsername();
        String password = user.getPassword();

        if(name.equals(username) && pass.equals(password)){
            session.setAttribute("user",username);
            dis = request.getRequestDispatcher("/backend/home.jsp");
            dis.forward(request, response);
        }else{
            dis = request.getRequestDispatcher("/index.jsp");
            out.println("Login Salah!!");
            dis.include(request, response);
            out.close();
            }
UsersJpaController ujc = new UsersJpaController();
Users users = new Users();
users = ujc.findUsers(username);
if (users != null) {
if (users.getPassword().equalsIgnoreCase(password)) {
session.setAttribute("sessionusername", username);
out.println("Hallo" + session.getAttribute("sessionusername"));
} else {out.println("Password Invalid");}
else {out.println("Username Invalid");}}*/
//UsersJpaController ujc = new UsersJpaController();



//out.println("Hallo" + session.getAttribute("sessionusername"));

    
    //out.println("Username Invalid");



   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}