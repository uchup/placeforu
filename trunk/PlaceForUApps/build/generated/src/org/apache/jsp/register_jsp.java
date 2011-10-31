package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

<<<<<<< .mine
  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;
=======
  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;
>>>>>>> .r54

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
<<<<<<< .mine
=======
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");
>>>>>>> .r54

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Pendaftaran User</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Pendaftaran User</h2>\n");
      out.write("         <form method='post' action='register'>\n");
      out.write("        <fieldset>\n");
<<<<<<< .mine
      out.write("        Nama            :\n");
      out.write("        <input type='text' name='nama' />\n");
      out.write("        <br><br>\n");
      out.write("         <label>tipe pengguna\n");
      out.write("        <select name=\"tipe\" id=\"tipe\">\n");
      out.write("          <option>  </option>\n");
      out.write("          <option>Pemilik Tempat</option>\n");
      out.write("          <option>Penyewa Tempat</option>\n");
      out.write("        </select>\n");
      out.write("        </label>\n");
      out.write("        <br><br>\n");
      out.write("        Email:\n");
      out.write("        <input type='text' name='email' />\n");
      out.write("        <br><br>\n");
      out.write("        Alamat:\n");
      out.write("        <input type='text' name='alamat' />\n");
      out.write("        <br><br>\n");
      out.write("        No.Hp:\n");
      out.write("        <input type='text' name='hape' />\n");
      out.write("        <br><br>\n");
      out.write("        No.Telp:\n");
      out.write("        <input type='text' name='telp' />\n");
      out.write("        <br><br>\n");
      out.write("        Username:\n");
      out.write("        <input type='text' name='usname' />\n");
      out.write("        <br><br>\n");
      out.write("        Password:\n");
      out.write("        <input type='password' name='psword' />\n");
      out.write("        <br><br>\n");
      out.write("        <input type='submit' value='Daftar' />\n");
      out.write("        </fieldset>\n");
=======
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                <fieldset>\n");
      out.write("                <legend><h4>Profil</h4></legend>    \n");
      out.write("                    <table>   \n");
      out.write("                        <tr>\n");
      out.write("                            <td>Nama</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='text' name='nama' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Tipe pengguna</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select>\n");
      out.write("                                    <option value=\"1\">Pemilik Tempat</option>\n");
      out.write("                                    <option value=\"2\">Penyewa Tempat</option>\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Email</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='text' name='email' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Alamat</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='text' name='alamat' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>No.Hp</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='text' name='hape' /></td>\n");
      out.write("                        </tr>       \n");
      out.write("                        <tr>\n");
      out.write("                            <td>No.Telp</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='text' name='telp' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Foto</td>\n");
      out.write("                            <td>:</td>\n");
      out.write("                            <td><input type='file' name='foto' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table> \n");
      out.write("                </fieldset>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <fieldset>\n");
      out.write("                    <legend><h4>Akun Pengguna</h4></legend>\n");
      out.write("                    <table>   \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Username</td>\n");
      out.write("                        <td>:</td>\n");
      out.write("                        <td><input type='text' name='usname' /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password</td>\n");
      out.write("                        <td>:</td>\n");
      out.write("                        <td><input type='password' name='psword' /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type='submit' value='Register' /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    </table> \n");
      out.write("                    </fieldset>\n");
      out.write("                </table>\n");
      out.write("                </fieldset>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
>>>>>>> .r54
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
