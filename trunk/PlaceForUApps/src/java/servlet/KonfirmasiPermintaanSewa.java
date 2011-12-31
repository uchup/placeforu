/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarSewa;
import entity.Sewa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ika
 */
public class KonfirmasiPermintaanSewa extends HttpServlet {

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
         String usname = request.getParameter("usname");
        int konfirm = Integer.parseInt(request.getParameter("konfirm"));
        Long idSewa = Long.parseLong(request.getParameter("idSewa"));
        RequestDispatcher dis = null;
        String message = null;
        DaftarSewa a = new DaftarSewa();
        Sewa sewa = new Sewa();
        sewa = a.getSewaFromId(idSewa);
        try {
            //if registration is accepted
            if (konfirm == 1) {
                sewa.setStatus(1);
                a.konfirmSewa(sewa);

                RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/successConfirmation.jsp");
                message ="Penyewaan berhasil disetujui";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);

            } //if registration is rejected
            else {
                a.removeSewa(sewa);
                RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/successConfirmation.jsp");
                message ="Penyewaan berhasil ditolak";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
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
