/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarGedung;
import entity.Gedung;
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
public class TambahGedung extends HttpServlet {

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
        RequestDispatcher dis = null;
        String message = null;
        DaftarGedung dg = new DaftarGedung();
        Gedung gd = new Gedung();

        String nama_gedung = request.getParameter("nama_gedung");
        int tipe_gedung = Integer.parseInt(request.getParameter("tipe_gedung"));
        int kategori_gedung = Integer.parseInt(request.getParameter("kategori_gedung"));
        String propinsi_gedung = request.getParameter("propinsi_gedung");
        String kota_gedung = request.getParameter("kota_gedung");
        String alamat_gedung = request.getParameter("alamat_gedung");
        String fasilitas_gedung = request.getParameter("fasilitas_gedung");
        String deskripsi_gedung = request.getParameter("deskripsi_gedung");
        String email_gedung = request.getParameter("email_gedung");
        String telp_gedung = request.getParameter("telp_gedung");
        int id_pemilik=851;
        
        if (nama_gedung.equals("") || tipe_gedung==0 || kategori_gedung==0
                || propinsi_gedung.equals("") || kota_gedung.equals("") || deskripsi_gedung.equals("") || telp_gedung.equals("")) {
            RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/error_page.jsp");
                message ="Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        else{
            
                gd.setNamaGedung(nama_gedung);
                gd.setTipeGedung(tipe_gedung);
                gd.setKategoriGedung(kategori_gedung);
                gd.setPropinsiGedung(propinsi_gedung);
                gd.setKotaGedung(kota_gedung);
                gd.setAlamatGedung(alamat_gedung);
                gd.setEmailGedung(email_gedung);
                gd.setTelpGedung(telp_gedung);
                gd.setDeskripsiGedung(deskripsi_gedung);
                gd.setFasilitasGedung(fasilitas_gedung);
                gd.setIdPemilik(id_pemilik);
                dg.addGedung(gd);
                RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/successSaving.jsp");
                message ="Gedung berhasil ditambahkan";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
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
        String destination = "/pemilik/entriInformasiGedung.jsp";

        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(request, response);
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
