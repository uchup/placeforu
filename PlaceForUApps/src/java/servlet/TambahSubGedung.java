/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import entity.DaftarGedung;
import entity.DaftarSubGedung;
import entity.DaftarUser;
import entity.Gedung;
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
        String page;
        DaftarSubGedung a = new DaftarSubGedung();
        SubGedung sub = new SubGedung();
        Gedung ged =new Gedung();
        DaftarGedung dg = new DaftarGedung();
        HttpSession session = request.getSession();
        DaftarUser du = new DaftarUser();
        User u = new User();

         String username = (String) session.getAttribute("sessionusername");
        //Long id_gedung1 = Long.parseLong(request.getParameter("id"));
         u = du.getUserFromName(username);
      // ged = dg.getGedung(id_gedung1);

        String nama_sub_gedung = request.getParameter("nama_sub_gedung");
        String tipe_sub_gedung = request.getParameter("tipe_sub_gedung");
        String harga = request.getParameter("harga");
        String satuan = request.getParameter("satuan");
        String kapasitas = request.getParameter("kapasitas");
        String luas = request.getParameter("luas");
        String fasilitas_sub = request.getParameter("fasilitas_sub");
        String deskripsi_sub = request.getParameter("deskripsi_sub");
        String status = request.getParameter("status");
        long id_pemilik=  u.getId();

         Long idGedung = Long.parseLong(request.getParameter("id_gedung"));
         Gedung gd = new Gedung();
         gd = dg.getGedung(idGedung);
         request.setAttribute("subgedung", gd);




        if (nama_sub_gedung.equals("") || tipe_sub_gedung.equals("") || harga.equals("")
                || deskripsi_sub.equals("") || fasilitas_sub.equals("")||status.equals("")) {
            RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/error_page.jsp");
                message ="Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        else{
            boolean hasilCheck = dg.cekGedungPemilik(nama_sub_gedung,idGedung);
            if (!hasilCheck) {
                sub.setNama_sub_gedung(nama_sub_gedung);
                sub.setTipe_sub_gedung(tipe_sub_gedung);
                sub.setDeskripsi_sub(deskripsi_sub);
                sub.setFasilitas_sub(fasilitas_sub);
                sub.setHarga(harga);
                sub.setKapasitas(kapasitas);
                sub.setLuas(luas);
                sub.setStatus(status);
                sub.setSatuan(satuan);
                sub.setId_pemilik(id_pemilik);
                sub.setId_gedung(idGedung);
                a.addSubGedung(sub);

                RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/successSaving2.jsp");
                message ="Sub Gedung berhasil ditambahkan";
                page = "ListSubGedung";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
            }
             else{
              RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/error_page.jsp");
            message = "Sub Gedung sudah ditambahkan sebelumnya, silahkan masukkan sub gedung lainnya ";
            request.setAttribute("message", message);
            requestDispatcher.forward(request, response);
            }
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
        DaftarGedung dg = new DaftarGedung();
        Gedung gd = new Gedung();
        DaftarUser du = new DaftarUser();
        User u = new User();

        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");
            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = du.checkUser(username);
            if (hasilCheck) {
                //mengambil user berdasarkan username dari Daftar User
                u = du.getUserFromName(username);
                long idPemilik = u.getId();

                //jika pengguna merupakan pemilik
                if (u.getTipe() == 1) {
                 Long id_gedung = Long.parseLong(request.getParameter("id"));
        gd = (Gedung) dg.getGedung(id_gedung);
        request.setAttribute("gedung", gd);
        dis = request.getRequestDispatcher("/pemilik/entriInformasiSub.jsp");
        dis.include(request, response);

                } else if (u.getTipe() == 0) {
                    Long id_gedung = Long.parseLong(request.getParameter("id"));
        gd = (Gedung) dg.getGedung(id_gedung);
        request.setAttribute("gedung", gd);
        dis = request.getRequestDispatcher("/admin/entriInformasiSub.jsp");
        dis.include(request, response);

                }
            } else {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
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
