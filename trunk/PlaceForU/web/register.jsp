<%-- 
    Document   : register
    Created on : May 1, 2011, 10:27:33 PM
    Author     : luwis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Register</title>
    </head>
    <body>
    <div align="center">
      <table width="720" border="0" cellspacing="10" cellpadding="0">
        <tr>
          <td height="100%" valign="top"><div class="cart" align="right"><a href="controller?page=cart"><img src="images/cart.jpg" width="33" height="32" /></a></div></td>
        </tr>
        <tr>
          <td height="100%"><div align="center"><img src="images/banner.jpg" width="700" height="118" /></div></td>
        </tr>
        <tr>
          <td height="100%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="150" height="20">&nbsp;</td>
              <td width="19" height="20">&nbsp;</td>
              <td width="530" height="20">&nbsp;</td>
            </tr>
            <tr>
              <td width="150" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="5%" height="30" background="images/header.png">&nbsp;</td>
                  <td height="30" background="images/header.png"><span class="category">Kategori</span></td>
                </tr>

                <c:forEach items="${categories}" var="cat">
                    <tr>
                      <td width="5%" height="30" bgcolor="#EFEFEF">&nbsp;</td>
                      <td height="30" bgcolor="#EFEFEF"><span class="menucategory"><a href="controller?page=index&catid=${cat.id}">${cat.name}</a></span></td>
                    </tr>
                </c:forEach>

                <tr>
                  <td width="5%" height="30" bgcolor="#EFEFEF">&nbsp;</td>
                  <td height="30" bgcolor="#EFEFEF"><span class="menucategory"><a href="controller?page=index&catid=0">Semua Kategori</a></span></td>
                </tr>
              </table></td>
              <td width="19">&nbsp;</td>
              <td valign="top">
                  <form id="form1" name="form1" method="post" action="controller?page=buy">
                    <table width="100%" border="0" cellspacing="0" cellpadding="2">
                    <tr>
                      <td width="12%" height="30" class="menucategory">Nama</td>
                      <td width="88%" height="30"><label>
                        <input name="nama" type="text" id="nama" size="40" />
                      </label></td>
                    </tr>
                    <tr>
                      <td width="12%" height="30" class="menucategory">Telpon</td>
                      <td width="88%" height="30"><label>
                        <input name="telpon" type="text" id="telpon" size="20" />
                      </label></td>
                    </tr>
                    <tr>
                      <td width="12%" height="30" class="menucategory">Alamat</td>
                      <td width="88%" height="30"><label>
                        <input name="alamat" type="text" id="alamat" size="70" />
                      </label></td>
                    </tr>
                    <tr>
                      <td width="12%" height="30">&nbsp;</td>
                      <td width="88%" height="30">&nbsp;</td>
                    </tr>
                    <tr>
                      <td height="30" colspan="2"><div align="center">
                        <label>
                        <input type="submit" name="button" id="button" value="Submit" />
                        </label>
                      </div></td>
                      </tr>
                  </table>
                </form>
              </td>
            </tr>
          </table></td>
        </tr>
      </table>
    </div>
    </body>
</html>

