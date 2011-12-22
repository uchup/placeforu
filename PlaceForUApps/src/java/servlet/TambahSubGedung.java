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
public class TambahSubGedung extends HttpServlet {

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
        DaftarSubGedung a = new DaftarSubGedung();
        SubGedung sub = new SubGedung();

        String nama_sub_gedung = request.getParameter("nama_sub_gedung");
        int tipe_sub_gedung = Integer.parseInt(request.getParameter("tipe_sub_gedung"));
        String harga = request.getParameter("harga");
        
        String kapasitas = request.getParameter("kapasitas");
        String luas = request.getParameter("luas");
        String fasilitas_sub = request.getParameter("fasilitas_sub");
        String deskripsi_sub = request.getParameter("deskripsi_sub");
        int status = Integer.parseInt(request.getParameter("status"));
        int id_pemilik=851;
        int id_gedung=11;

        if (nama_sub_gedung.equals("") || tipe_sub_gedung==0 || harga.equals("")
                || deskripsi_sub.equals("") || fasilitas_sub.equals("")||status==0) {
            RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/error_page.jsp");
                message ="Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        else{
                sub.setDeskripsiSubGedung(deskripsi_sub);
                sub.setFasilitasSubGedung(fasilitas_sub);
                sub.setGedung(null);
                RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/successSaving.jsp");
                message ="Sub Gedung berhasil ditambahkan";
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
       // long idGedung = Long.parseLong(sessio));
        DaftarGedung dg = new DaftarGedung();
        Gedung gedung = new Gedung();
        //gedung = dg.getGedung(idGedung);
        String destination = "/pemilik/entriInformasiSub.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.include(request, response);
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
