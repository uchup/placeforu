<%-- 
    Document   : index
    Created on : May 1, 2011, 1:12:09 PM
    Author     : luwis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Computer Shop</title>
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
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">

                      <c:forEach items="${products}" var="prod">
                      <tr>
                      <td width="530" height="98" valign="top" bgcolor="#A8A8FF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="30%" height="98"><div align="center"><img src="images/product/${prod.image}" width="129" height="129" /></div></td>
                          <td width="70%" height="98" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                            <tr>
                              <td><span class="productname">${prod.name}</span></td>
                            </tr>
                            <tr>
                              <td><span class="specification">${prod.spec}</span></td>
                            </tr>
                            <tr>
                              <td><span class="price"><fmt:formatNumber value="${prod.price}" currencySymbol="Rp " type="currency"/></span></td>
                            </tr>
                            <tr>
                              <td><div align="right" class="button"><a href="controller?page=cart&prodid=${prod.id}"><img src="images/button.png" width="60" height="20" /></a></div></td>
                            </tr>
                          </table></td>
                          </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td width="530" height="5" valign="top">&nbsp;</td>
                    </tr>
                    </c:forEach>

                  </table>
              </td>
            </tr>
          </table></td>
        </tr>
      </table>
    </div>
    </body>
</html>
