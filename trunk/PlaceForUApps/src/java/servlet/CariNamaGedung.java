/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarGedung;
import entity.Gedung;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Widiasa
 */
public class CariNamaGedung extends HttpServlet {

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
        DaftarGedung dg = new DaftarGedung();
        Gedung gd = new Gedung();
        RequestDispatcher dis = null;
        List<Gedung> listGedung = new ArrayList<Gedung>();
        try {
            String namaGedung = request.getParameter("namagedung");
            String kategoriGedung = request.getParameter("kategorigedung");
            if (kategoriGedung.equals("")) {
                listGedung = dg.searchDaftarGedungFromNama(namaGedung);
                
            } else if (namaGedung.equals("")) {
                listGedung = dg.searchDaftarGedungFromKategori(kategoriGedung);
            }
            else if(!kategoriGedung.equals("")&&!namaGedung.equals("")){
                listGedung = dg.searchDaftarGedungFromNamaDanKategori(namaGedung, kategoriGedung);
            }else{
                response.sendRedirect("../PlaceForUApps_28Nov/");
            }
            request.setAttribute("hasilcari", listGedung);
            dis = request.getRequestDispatcher("listcarigedung.jsp");
            dis.include(request, response);
        } finally {
            out.close();
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
