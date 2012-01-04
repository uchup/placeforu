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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdministrasiBaru extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;

        String message = null;

        //mendapatkan nilai inputan
        Long idSewa = Long.parseLong(request.getParameter("idSewa"));
        Long idPemilik = Long.parseLong(request.getParameter("idPemilik"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tgl = request.getParameter("tgl");
        String bln = request.getParameter("bln");
        String thn = request.getParameter("thn");
        String sampai = thn + "-" + bln + "-" + tgl;
        Date tanggal = dateFormat.parse(sampai);
        String no_bukti = request.getParameter("no_bukti");
        String media_bayar = request.getParameter("media_bayar");
        String bayar = request.getParameter("jml_bayar");
        int jml_bayar = Integer.parseInt(request.getParameter("jml_bayar"));

        Administrasi adm = new Administrasi();
        DaftarAdministrasi da = new DaftarAdministrasi();
        Sewa sw = new Sewa();
        DaftarSewa ds = new DaftarSewa();
        HttpSession session = request.getSession();
        DaftarUser du = new DaftarUser();
        User u = new User();

        adm.setIdSewa(idSewa);
        adm.setIdPemilik(idPemilik);
        adm.setTglBayar(tanggal);
        adm.setMediaBayar(media_bayar);
        adm.setNoBukti(no_bukti);
        adm.setJumlahBayar(jml_bayar);
        adm.setStatusPembayaran(0);
        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");
            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = du.checkUser(username);
            if (hasilCheck) {
                //mengambil user berdasarkan username dari Daftar User
                u = du.getUserFromName(username);
                //long idPemilik= u.getId();

                //jika pengguna merupakan penyewa tempat, maka akan diarahkan ke halaman daftar Gedung untuk pemilik
                if (u.getTipe() == 2) {
                    try {
                        //jika ada field bertanda bintang yang kosong
                        if (no_bukti.equals("") || media_bayar.equals("") || bayar.equals("")) {
                            RequestDispatcher requestDispatcher =
                                    request.getRequestDispatcher("/error_page.jsp");
                            message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                            request.setAttribute("message", message);
                            requestDispatcher.forward(request, response);
                        } else {

                            sw = ds.getSewaFromId(idSewa);

                            //jika jumlah pembayaran yang dimasukkan melebihi sisa pembayaran yang harus dilakukan
                            if (jml_bayar <= sw.getSisaBayar()) {

                                //menambahkan histori administrasi
                                da.addAdministrasi(adm);

                                //mengarahkan pada halaman successUpdating
                                RequestDispatcher requestDispatcher =
                                        request.getRequestDispatcher("/successSaving.jsp");
                                message = "Konfirmasi Pembayaran sedang dilakukan, harap menunggu konfirmasi";
                                String page = "HistoriAdministrasi";
                                request.setAttribute("message", message);
                                request.setAttribute("page", page);
                                requestDispatcher.forward(request, response);
                            } else {
                                RequestDispatcher requestDispatcher =
                                        request.getRequestDispatcher("/error_page.jsp");
                                message = "Jumlah pembayaran yang Anda masukkan melebihi sisa pembayaran yang harus dibayarkan";
                                request.setAttribute("message", message);
                                requestDispatcher.forward(request, response);
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
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

        String username = (String) session.getAttribute("sessionusername");
        u = du.getUserFromName(username);

        Long idSewa = Long.parseLong(request.getParameter("idSewa"));
        sw = (Sewa) ds.getSewaFromId(idSewa);

        Long idSubGedung = sw.getIdSubGedung();
        sg = dsg.getSubGedung(idSubGedung);

        Long idGedung = sw.getIdGedung();
        gd = dg.getGedung(idGedung);

        request.setAttribute("sewa", sw);
        request.setAttribute("gedung", gd);
        request.setAttribute("subgedung", sg);
        request.setAttribute("akun", u);
        dis = request.getRequestDispatcher("/penyewa/administrasiBaru.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AdministrasiBaru.class.getName()).log(Level.SEVERE, null, ex);
        }
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
