/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarUser;
import entity.User;
import entity.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class KonfirmasiRegistrasi extends HttpServlet {

    /**
     * kelas ini digunakan untuk melihat profil penyewa dengan kondisi session todak boleh null
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usname = request.getParameter("uname");
        Long userid = Long.parseLong(request.getParameter("userid"));
        int konfirm = Integer.parseInt(request.getParameter("konfirm"));
        RequestDispatcher dis = null;
        String message = null;
        DaftarUser a = new DaftarUser();
        User user = new User();
        user = a.getUserFromName(usname);
        user.setStatus(1);
        try {
            //if registration is accepted
            if (konfirm == 1) {
                a.editUser(user);
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("konfirmasiSukses.jsp");
                message = "Registrasi berhasil disetujui";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } //if registration is rejected
            else {
                a.deleteUser(userid);
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("konfirmasiSukses.jsp");
                message = "Registrasi berhasil ditolak";
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

        DaftarUser du = new DaftarUser();
        RequestDispatcher dis = null;
        User u = new User();
        List<User> users = du.getUnconfirmedUsers();
        request.setAttribute("pengguna", users);
        //diarahkan ke halaman profil penyewa tempat
        dis = request.getRequestDispatcher("/admin/konfirmasiRegistrasi.jsp");
        dis.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(KonfirmasiRegistrasi.class.getName()).log(Level.SEVERE, null, ex);
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
