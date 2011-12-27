/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarGedung;
import entity.DaftarSubGedung;
import entity.Gedung;
import entity.SubGedung;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuni
 */
public class EditSubGedung extends HttpServlet {

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
        String nama_sub_gedung = request.getParameter("nama_sub_gedung");
        int tipe_sub_gedung = Integer.parseInt(request.getParameter("tipe_sub_gedung"));
        String harga = request.getParameter("harga");
        int satuan = Integer.parseInt(request.getParameter("satuan"));
        String kapasitas = request.getParameter("kapasitas");
        String luas = request.getParameter("luas");
        String fasilitas_sub = request.getParameter("fasilitas_sub");
        String deskripsi_sub = request.getParameter("deskripsi_sub");
        int status = Integer.parseInt(request.getParameter("status"));
        Long id = Long.parseLong(request.getParameter("id_sub_gedung"));
        int id_gedung = 301;

        DaftarSubGedung ds = new DaftarSubGedung();
        RequestDispatcher page = null;
        SubGedung gd = new SubGedung();
        gd = ds.getSubGedung(id);
        //Long id_sub_gedung = Long.parseLong(request.getParameter("idsub"));
        //gd = (SubGedung) ds.getSubGedung(id_sub_gedung);
        //request.setAttribute("subgedung", gd);

       
        
        //int id_gedung = Integer.parseInt(request.getParameter("id_gedung"));
        //Long idGedung = Long.parseLong(request.getParameter("id_gedung"));
        
       // gd = ds.getSubGedung(id_sub_gedung);
//        gd.setId_gedung(id_gedung);
//        gd.setDeskripsi_sub(deskripsi_sub);
//        gd.setFasilitas_sub(fasilitas_sub);
//        gd.setHarga(harga);
//        gd.setKapasitas(kapasitas);
//        gd.setLuas(luas);
//        gd.setNama_sub_gedung(nama_sub_gedung);
//        gd.setSatuan(satuan);
//        gd.setStatus(status);
//        gd.setTipe_sub_gedung(tipe_sub_gedung);
        request.setAttribute("pemilik", gd);
        try {
           if (nama_sub_gedung.equals("") || tipe_sub_gedung==0 || harga.equals("")
                || deskripsi_sub.equals("") || fasilitas_sub.equals("")||status==0) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } else {

                ds.editSubGedung(gd);
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/successUpdating.jsp");
                message = "Informasi Sub Gedung berhasil diubah ";
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


        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        DaftarSubGedung ds = new DaftarSubGedung();
        SubGedung gd = new SubGedung();

        Long id_sub_gedung = Long.parseLong(request.getParameter("idsub"));
        gd = (SubGedung) ds.getSubGedung(id_sub_gedung);
        request.setAttribute("subgedung", gd);
        dis = request.getRequestDispatcher("/pemilik/editSubGedung.jsp");
        dis.include(request, response);
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
