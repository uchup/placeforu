/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import entity.DaftarGedung;
import entity.DaftarUser;
import entity.Gedung;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Widiasa
 */
public class UploadFotoGedung extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // bisa diganti sesuai spesifikasi
    private static final String TMP_DIR_PATH = "D:\\Project\\versiterbaru\\PlaceForUApps\\tmp";
    private File tmpDir;
    // bisa diganti sesuai spesifikasi
    private static final String DESTINATION_DIR_PATH ="/gedung";
    private File destinationDir;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        tmpDir = new File(TMP_DIR_PATH);
        if(!tmpDir.isDirectory()) {
            throw new ServletException(TMP_DIR_PATH + " is not a directory");
        }
        String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
        destinationDir = new File(realPath);
        if(!destinationDir.isDirectory()) {
            throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
	response.setContentType("text/plain");
        Gedung gedung = new Gedung();
        DaftarGedung dg = new DaftarGedung();
        HttpSession session = request.getSession();
        String message = null;

        Long id = Long.valueOf(request.getParameter("id")) ;
        gedung = dg.getGedung(id);

	DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
		/*
		 *Set the size threshold, above which content will be stored on disk.
		 */
		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
		/*
		 * Set the temporary directory to store the uploaded files of size above threshold.
		 */
		fileItemFactory.setRepository(tmpDir);

	ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

        try {
			/*
			 * Parse the request
			 */
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();
			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				/*
				 * Handle Form Fields.
				 */
				if(item.isFormField()) {
					out.println("File Name = "+item.getFieldName()+", Value = "+item.getString());
				} else {
					//Handle Uploaded files.
                                        gedung.setFotoUtamaGedung(item.getName());
//					out.println("Field Name = "+item.getFieldName()+
//						", File Name = "+item.getName()+
//						", Content type = "+item.getContentType()+
//						", File Size = "+item.getSize());
					/*
					 * Write file to the ultimate location.
					 */
					File file = new File(destinationDir,item.getName());
					item.write(file);
                                        dg.editGedung(gedung);
                                        
                                        response.sendRedirect("../PlaceForUApps_28Nov/EditGedung?id="+id+"");
				}
				out.close();
			}
		}catch(FileUploadException ex) {
			log("Error encountered while parsing the request",ex);
		} catch(Exception ex) {
			log("Error encountered while uploading file",ex);
		}

	}

}