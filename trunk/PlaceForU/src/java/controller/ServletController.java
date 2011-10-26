/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

packagee controller;

import dbase.DBcategory;
import dbase.DBconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import page.GoBuy;
import page.GoCart;
import page.GoIndex;

/**
 *
 * @author luwis
 */
public class ServletController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String page = request.getParameter("page");

        DBconnection dbConn = new DBconnection();
        List<Category> category = new ArrayList<Category>();
        DBcategory dbCat = new DBcategory(dbConn.getConnection());
        try{
            category = dbCat.getAllCategory();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            dbConn.closeConnection();
        }
        request.setAttribute("categories", category);

        RequestDispatcher dis = null;
        if(page != null){
            if(page.equals("index")){
                GoIndex index = new GoIndex(request);
                dis = request.getRequestDispatcher(index.getPage());
            } else if(page.equals("cart")){
                GoCart cart = new GoCart(request);
                dis = request.getRequestDispatcher(cart.getPage());
            } else if(page.equals("register")){
                dis = request.getRequestDispatcher("register.jsp");
            } else if(page.equals("buy")){
                GoBuy buy = new GoBuy(request);
                GoIndex index = new GoIndex(request);
                dis = request.getRequestDispatcher(index.getPage());
            }
        } else {
            GoIndex home = new GoIndex(request);
            dis = request.getRequestDispatcher(home.getPage());
        }
        dis.forward(request, response);
    } 

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
