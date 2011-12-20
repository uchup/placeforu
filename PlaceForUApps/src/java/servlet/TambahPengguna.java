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
 * @author Widiasa
 */
public class TambahPengguna extends HttpServlet {
   
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
        HttpSession session = request.getSession();

        String nama = request.getParameter("nama");
        int tipe = Integer.parseInt(request.getParameter("tipe"));
        String email = request.getParameter("email");
        String telp = request.getParameter("telp");
        String alamat = request.getParameter("alamat");
        String hape = request.getParameter("hape");
        String usname = request.getParameter("usname");
        String pass = request.getParameter("psword");
        int status = Integer.parseInt(request.getParameter("status"));

        User user = new User();
        RequestDispatcher page = null;
        DaftarUser daftar = new DaftarUser();

        if (nama.equals("") || email.equals("") || telp.equals("")
                || alamat.equals("") || usname.equals("") || pass.equals("")) {
            RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/error_page.jsp");
                message ="Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        else{
            boolean hasilCheck = daftar.checkUser(usname);
            if (!hasilCheck) {
                user.setNama(nama);
                user.setTipe(tipe);
                user.setEmail(email);
                user.setTelp(telp);
                user.setAlamat(alamat);
                user.setHape(hape);
                user.setUsername(usname);
                user.setPassword(pass);
                user.setStatus(status);
                daftar.addUser(user);
                List<User> users = daftar.getUsers();
            request.setAttribute("pengguna", users);
          //diarahkan ke halaman profil penyewa tempat
            response.sendRedirect("/PlaceForUApps/admin/daftarpengguna");
            } else {
                   //out.println("Username telah terdaftar");
                message ="Username telah terdaftar, ulangi lagi ";
                request.setAttribute("message", message);
                page = request.getRequestDispatcher("/error_page.jsp");
                    page.forward(request, response);
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
        DaftarUser du = new DaftarUser();
        User u = new User();

        //mengambil parameter yang sudah dikirim dari halaman daftarPengguna.jsp

       
        //diarahkan ke halaman profil penyewa tempat
        dis = request.getRequestDispatcher("/admin/tambahPengguna.jsp");
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
