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
import java.util.List;
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
public class ListSubGedung extends HttpServlet {

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
        DaftarGedung dg = new DaftarGedung();
        DaftarSubGedung sub = new DaftarSubGedung();
        User u = new User();
        Gedung g = new Gedung();

        Long id_gedung = Long.parseLong(request.getParameter("id"));
        List<SubGedung> daftar_sub_gedung = sub.getDaftarSubGedung(id_gedung);
        request.setAttribute("gedung", daftar_sub_gedung);
        
        //Long idGedung = Long.parseLong(request.getParameter("id_gedung"));
         Gedung gd = new Gedung();
         gd = dg.getGedung(id_gedung);
         request.setAttribute("gedungid", gd);



        //request.setAttribute("ged", daftar_sub_gedung);
        request.setAttribute("akun", u);


        //SubGedung gd = new SubGedung();
        //Long id_sub = Long.parseLong(request.getParameter("idsub"));
        //gd = (SubGedung) sub.getSubGedung(id_sub);
        //request.setAttribute("subg", gd);


        dis = request.getRequestDispatcher("/pemilik/ListSubGedung.jsp");
        dis.include(request, response);


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
