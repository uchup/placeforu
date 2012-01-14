/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
import java.util.Calendar;
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
public class SewaBaru extends HttpServlet {

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
        DaftarGedung dg = new DaftarGedung();
        Gedung gd = new Gedung();
        HttpSession session = request.getSession();
        DaftarUser du = new DaftarUser();
        User u = new User();
        DaftarSubGedung ds = new DaftarSubGedung();
        SubGedung sg = new SubGedung();
        Sewa sewa = new Sewa();
        DaftarSewa daftarSewa = new DaftarSewa();
        String page = null;
        String message = null;

        //mengambil nilai masukan dari form pada sewaBaru.jsp
        Long idGedung = Long.parseLong(request.getParameter("idGedung"));
        Long idSubGedung = Long.parseLong(request.getParameter("idSubGedung"));
        Long idPemilik = Long.parseLong(request.getParameter("idPemilik"));
        String username = (String) session.getAttribute("sessionusername");
        u = du.getUserFromName(username);
        long idPenyewa = u.getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tg_mulai = request.getParameter("tgl_mulai");
        String bl_mulai = request.getParameter("bln_mulai");
        String th_mulai = request.getParameter("thn_mulai");
        String tg_sampai = request.getParameter("tgl_sampai");
        String bl_sampai = request.getParameter("bln_sampai");
        String th_sampai = request.getParameter("thn_sampai");
        int harga = Integer.parseInt(request.getParameter("harga"));
        String mulai = th_mulai + "-" + bl_mulai + "-" + tg_mulai;
        String sampai = th_sampai + "-" + bl_sampai + "-" + tg_sampai;
        Date tgl_mulai = dateFormat.parse(mulai);
        Date tgl_sampai = dateFormat.parse(sampai);




        try {
            //Jika ada field bertanda bintang yang kosong (tidak diisi)
            if (tg_mulai.equals("") || bl_mulai.equals("") || th_mulai.equals("")
                    || tg_sampai.equals("") || bl_sampai.equals("") || th_sampai.equals("")) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            }
            else {
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();

                c1.set(Integer.parseInt(th_mulai), Integer.parseInt(bl_mulai), Integer.parseInt(tg_mulai));
                c2.set(Integer.parseInt(th_sampai), Integer.parseInt(bl_sampai), Integer.parseInt(tg_sampai));

                //Membandingkan 2 inputan pada Field waktu mulai penyewaan dengan waktu akhir penyewaan
                //Jika masukan tanggal pada field akhir sebelum tanggal sewa
                if (c2.before(c1)) {
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message = "Waktu akhir penyewaan harus setelah waktu awal penyewaan";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                }//end of if
                else {
                    sg = ds.getSubGedung(idSubGedung);
                    //Jika sub gedung masih disewa
                    if (sg.getStatus().equals("Telah Disewa")) {
                        RequestDispatcher requestDispatcher =
                                request.getRequestDispatcher("/error_page.jsp");
                        message = "Sub Gedung masih disewa oleh penyewa lainnya, silahkan lakukan pemesanan di lain waktu";
                        request.setAttribute("message", message);
                        requestDispatcher.forward(request, response);

                    //Jika status sub gedung : tersedia
                    } else {
                        //memasukkan parameter pada tiap method di entitas user
                        sewa.setIdGedung(idGedung);
                        sewa.setIdSubGedung(idSubGedung);
                        sewa.setIdPenyewa(idPenyewa);
                        sewa.setIdPemilik(idPemilik);
                        sewa.setMulai(tgl_mulai);
                        sewa.setSampai(tgl_sampai);
                        sewa.setStatus(0);

                        //menghitung total harga sewa
                        long milliseconds1 = c1.getTimeInMillis();
                        long milliseconds2 = c2.getTimeInMillis();
                        long diff = milliseconds2 - milliseconds1;
                        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                        int totalHarga = harga * diffDays; //total harga adalah hasil kali antara harga sub gedung dengan jumlah hari sewa
                        sewa.setDurasi(diffDays);
                        sewa.setTotalHargaSewa(totalHarga);

                        //memasukkan sisa bayar secara default sama dengan total harga
                        sewa.setSisaBayar(totalHarga);

                        //menambahkan sewa ke dalam DaftarSewa
                        daftarSewa.addSewa(sewa);
                        RequestDispatcher requestDispatcher =
                                request.getRequestDispatcher("/successSaving.jsp");
                        message = "Permohonan sewa berhasil dikirimkan, Silahkan menunggu konfirmasi dari kami. Terima Kasih";
                        page = "HistoriSewa";
                        request.setAttribute("message", message);
                        request.setAttribute("page", page);
                        requestDispatcher.forward(request, response);
                    }
                }

            }
        }
        catch (Exception e) {
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
        HttpSession session = request.getSession();
        DaftarSubGedung ds = new DaftarSubGedung();
        SubGedung gd = new SubGedung();
        Gedung gedung = new Gedung();
        DaftarGedung dg = new DaftarGedung();
        DaftarUser du = new DaftarUser();
        User u = new User();


        String username = (String) session.getAttribute("sessionusername");
        u = du.getUserFromName(username);


        Long id_sub_gedung = Long.parseLong(request.getParameter("idsub"));
        gd = (SubGedung) ds.getSubGedung(id_sub_gedung);
        Long idGedung = gd.getId_gedung();
        gedung = dg.getGedung(idGedung);
        request.setAttribute("subgedung", gd);
        request.setAttribute("akun", u);
        request.setAttribute("gedung", gedung);
        dis = request.getRequestDispatcher("/penyewa/sewaBaru.jsp");
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
            Logger.getLogger(SewaBaru.class.getName()).log(Level.SEVERE, null, ex);
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
