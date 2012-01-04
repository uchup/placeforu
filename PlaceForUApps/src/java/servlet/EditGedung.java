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
public class EditGedung extends HttpServlet {

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

        String message = null;
        String namaGedung = request.getParameter("nama_gedung");
        String tipe = request.getParameter("tipe_gedung");
        String kategori = request.getParameter("kategori_gedung");
        String tipeGedung = request.getParameter("tipe_gedung");
        String kategoriGedung = request.getParameter("kategori_gedung");
        String propinsiGedung = request.getParameter("propinsi_gedung");
        String kotaGedung = request.getParameter("kota_gedung");
        String alamatGedung = request.getParameter("alamat_gedung");
        String deskripsiGedung = request.getParameter("deskripsi_gedung");
        String fasilitasGedung = request.getParameter("fasilitas_gedung");
        String emailGedung = request.getParameter("email_gedung");
        String telpGedung = request.getParameter("telp_gedung");
        Long idGedung = Long.parseLong(request.getParameter("id_gedung"));


        Gedung gd = new Gedung();
        //RequestDispatcher page = null;
        DaftarGedung dg = new DaftarGedung();
        gd = dg.getGedung(idGedung);
       
        gd.setNamaGedung(namaGedung);
        gd.setTipeGedung(tipeGedung);
        gd.setKategoriGedung(kategoriGedung);
        gd.setPropinsiGedung(propinsiGedung);
        gd.setKotaGedung(propinsiGedung);
        gd.setAlamatGedung(alamatGedung);
        gd.setDeskripsiGedung(deskripsiGedung);
        gd.setFasilitasGedung(fasilitasGedung);
        gd.setEmailGedung(emailGedung);
        gd.setTelpGedung(telpGedung);
        request.setAttribute("pemilik", gd);
        
            if (namaGedung.equals("") || tipe.equals("") || kategori.equals("")
                    || propinsiGedung.equals("") || kotaGedung.equals("") || alamatGedung.equals("") || deskripsiGedung.equals("") || telpGedung.equals("")) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } else {

                dg.editGedung(gd);
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/successUpdating.jsp");
                message = "Data berhasil diubah ";
                String page = "ListGedung";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
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

        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        DaftarGedung dg = new DaftarGedung();
        Gedung gd = new Gedung();

        String idi = request.getParameter("id");
        if(idi!=null){
        Long id = Long.parseLong(idi);
        gd = (Gedung) dg.getGedung(id);
        request.setAttribute("gedung", gd);
        dis = request.getRequestDispatcher("/pemilik/editGedung.jsp");
        dis.include(request, response);
        }
        else
        response.sendRedirect("../PlaceForUApps_28Nov/ListGedung");
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
