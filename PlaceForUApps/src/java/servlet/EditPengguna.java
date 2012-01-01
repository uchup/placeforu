/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarUser;
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
public class EditPengguna extends HttpServlet {

    /** 
     *kelas ini digunakan untuk melakukan edit profil pengguna
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String message = null;
        String nama = request.getParameter("nama");
        String email = request.getParameter("email");
        String telp = request.getParameter("telp");
        String alamat = request.getParameter("alamat");
        String hape = request.getParameter("hape");
        String usname = request.getParameter("uname");
        String pass = request.getParameter("psword");

        User user = new User();
        DaftarUser a = new DaftarUser();
        user = a.getUserFromName(usname);

        user.setNama(nama);
        user.setEmail(email);
        user.setTelp(telp);
        user.setAlamat(alamat);
        user.setHape(hape);
        user.setUsername(usname);
        user.setPassword(pass);
        request.setAttribute("pengguna", user);
        try {
            if (nama.equals("") || email.equals("") || telp.equals("")
                    || alamat.equals("") || usname.equals("") || pass.equals("")) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } else {
                if (user.getPassword() != pass) {
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message = "Password Salah";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                } else {
                    a.editUser(user);
                    List<User> users = a.getUsers();
                    request.setAttribute("pengguna", users);
                    //diarahkan ke halaman profil penyewa tempat
                     RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/successUpdating.jsp");
                message = "Data Pengguna berhasil diubah";
                String page = "DaftarPengguna";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
           
               

   // }

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
        DaftarUser du = new DaftarUser();
        User u = new User();

        //mengambil parameter yang sudah dikirim dari halaman daftarPengguna.jsp
        String usname = request.getParameter("usname");
        u = du.getUserFromName(usname);
        request.setAttribute("pengguna", u);
        dis = request.getRequestDispatcher("/admin/editPengguna.jsp");
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
