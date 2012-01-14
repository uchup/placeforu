/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Administrasi;
import entity.DaftarAdministrasi;
import entity.DaftarSewa;
import entity.DaftarUser;
import entity.Sewa;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class HistoriAdministrasi extends HttpServlet {

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
        DaftarUser du = new DaftarUser();
        User u = new User();
        DaftarSewa ds = new DaftarSewa();
        Sewa s = new Sewa();
        Administrasi adm = new Administrasi();
        DaftarAdministrasi da = new DaftarAdministrasi();

        //untuk mendapatkan session dari user yang telah login
        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");

            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = du.checkUser(username);
            if (hasilCheck) {
                //mengambil user berdasarkan username dari Daftar User
                u = du.getUserFromName(username);
                long idAkun = u.getId();


                //jika  pengguna merupakan administrator, maka akan diarahkan ke halaman administrasi untuk administrator
                if (u.getTipe() == 0) {

                    //menampilkan semua histori penyewaan
                    List<Administrasi> df_adm = da.getAllAdm_Confirmed();
                    request.setAttribute("admin", df_adm);

                    dis = request.getRequestDispatcher("/admin/historiAdministrasi.jsp");
                    dis.include(request, response);

                } //jika  pengguna merupakan penyewa, maka akan diarahkan ke halaman histori administrasi untuk penyewa
                else if (u.getTipe() == 1) {

                    List<Administrasi> daftarAdministrasi = da.getAdministrasi_Confirmed(idAkun);
                    request.setAttribute("pemilik_1", daftarAdministrasi);

                    List<Administrasi> daftarAdministrasi2 = da.getAdministrasi_Unconfirmed(idAkun);
                    request.setAttribute("pemilik_0", daftarAdministrasi2);

                    dis = request.getRequestDispatcher("/pemilik/listAdministrasi.jsp");
                    dis.include(request, response);

                } //jika pengguna merupakan pemilik tempat, maka akan diarahkan ke halaman histori administrasi untuk pemilik
                else if (u.getTipe() == 2) {

                    List<Sewa> daftar_sewa2 = ds.getUtangPenyewa(idAkun);
                    request.setAttribute("penyewa_1", daftar_sewa2);

                    dis = request.getRequestDispatcher("/penyewa/historiAdministrasi.jsp");
                    dis.include(request, response);

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
