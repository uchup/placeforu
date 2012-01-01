/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Administrasi;
import entity.DaftarAdministrasi;
import entity.DaftarGedung;
import entity.DaftarSewa;
import entity.DaftarSubGedung;
import entity.DaftarUser;
import entity.Gedung;
import entity.Sewa;
import entity.SubGedung;
import entity.User;
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
 * @author Ika
 */
public class EditAdministrasi extends HttpServlet {

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
        HttpSession session = request.getSession();
        String message;

        Long idAdm = Long.parseLong(request.getParameter("id"));
        Long idSewa = Long.parseLong(request.getParameter("idSewa"));
        String bayar = request.getParameter("jml_bayar");
        String sisa = request.getParameter("sisa_bayar");
        int jml_bayar = Integer.parseInt(bayar);
        int sisa_bayar = Integer.parseInt(sisa);

        Administrasi adm = new Administrasi();
        DaftarAdministrasi da = new DaftarAdministrasi();
        Sewa sw = new Sewa();
        DaftarSewa ds = new DaftarSewa();
        User u = new User();
        DaftarUser du = new DaftarUser();

        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");
            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = du.checkUser(username);
            if (hasilCheck) {
                //mengambil user berdasarkan username dari Daftar User
                u = du.getUserFromName(username);


                //jika pengguna merupakan pemilik
                if (u.getTipe() == 1) {
                    if (idAdm.equals("") || bayar.equals("") || sisa.equals("")) {
                        RequestDispatcher requestDispatcher =
                                request.getRequestDispatcher("/error_page.jsp");
                        message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                        request.setAttribute("message", message);
                        requestDispatcher.forward(request, response);
                    } else {
                        //mengubah status pembayaran menjadi 1 (telah diterima)
                        adm = da.getAdministrasi(idAdm);
                        adm.setStatusPembayaran(1);
                        da.editAdministrasi(adm);
                        
                        //mengubah sisa pembayaran pada database Sewa
                        sw = ds.getSewaFromId(idSewa);
                        int sisa_bayar_db = sw.getSisaBayar();
                        int SisaBayar = sisa_bayar_db - sisa_bayar;
                        sw.setSisaBayar(SisaBayar);
                        ds.editSewa(sw);
                        
                        RequestDispatcher requestDispatcher =
                                request.getRequestDispatcher("/successUpdating.jsp");
                        message = "Administrasi berhasil dirubah. Konfirmasi pembayaran telah dilakukan" + SisaBayar;
                        String page = "HistoriAdministrasi";
                        request.setAttribute("message", message);
                        request.setAttribute("page", page);
                        requestDispatcher.forward(request, response);
                    }
                } else {
                    dis = request.getRequestDispatcher("index");
                    dis.forward(request, response);
                    out.close();

                }
            } else {
                dis = request.getRequestDispatcher("index");
                dis.forward(request, response);
                out.close();

            }
        } else {
            dis = request.getRequestDispatcher("index");
            dis.forward(request, response);
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
        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        DaftarSewa ds = new DaftarSewa();
        Sewa sw = new Sewa();

        HttpSession session = request.getSession();
        DaftarUser du = new DaftarUser();
        User u = new User();
        DaftarSubGedung dsg = new DaftarSubGedung();
        SubGedung sg = new SubGedung();
        Gedung gd = new Gedung();
        DaftarGedung dg = new DaftarGedung();
        Administrasi adm = new Administrasi();
        DaftarAdministrasi da = new DaftarAdministrasi();

        Long idAdm = Long.parseLong(request.getParameter("id"));

        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");
            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = du.checkUser(username);
            if (hasilCheck) {
                u = du.getUserFromName(username);


                //jika pengguna merupakan pemilik
                if (u.getTipe() == 1) {
                    adm = da.getAdministrasi(idAdm);


                    Long idSewa = adm.getIdSewa();
                    sw = (Sewa) ds.getSewaFromId(idSewa);

                    Long idSubGedung = sw.getIdSubGedung();
                    sg = dsg.getSubGedung(idSubGedung);

                    Long idGedung = sw.getIdGedung();
                    gd = dg.getGedung(idGedung);

                    Long idPenyewa = sw.getIdPenyewa();
                    u = du.getUserFromId(idPenyewa);

                    request.setAttribute("adm", adm);
                    request.setAttribute("sewa", sw);
                    request.setAttribute("gedung", gd);
                    request.setAttribute("subgedung", sg);
                    request.setAttribute("akun", u);
                    dis = request.getRequestDispatcher("/pemilik/editAdministrasi.jsp");
                    dis.include(request, response);
                } else {
                    dis = request.getRequestDispatcher("index");
                    dis.forward(request, response);
                    out.close();

                }
            }
        }

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
