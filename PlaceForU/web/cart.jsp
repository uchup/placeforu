<%-- 
    Document   : cart
    Created on : May 1, 2011, 10:20:58 PM
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
        <title>Cart</title>
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
                  <c:if test="${cart!=null}">
                      <c:set var="no" value="${1}"/>
                      <c:set var="total" value="${0}"/>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="30">
                      <table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#000000">
                        <tr>
                          <td width="8%" height="30" bgcolor="#FF9900"><div align="center" class="productname">No</div></td>
                          <td width="62%" height="30" bgcolor="#FF9900"><div align="center" class="productname">Nama Barang</div></td>
                          <td width="30%" height="30" bgcolor="#FF9900"><div align="center" class="productname">Harga</div></td>
                        </tr>
                        <c:forEach items="${products}" var="prod">
                        <tr>
                          <td width="8%" height="30"><div align="center" class="cart">${no}</div></td>
                          <td width="62%" height="30"><span class="cart">${prod.name}</span></td>
                          <td width="30%" height="30"><div align="right" class="cart"><fmt:formatNumber value="${prod.price}" currencySymbol="Rp " type="currency"/></div></td>
                        </tr>
                        <c:set var="no" value="${no+1}"/>
                        <c:set var="total" value="${total + prod.price}"/>
                        </c:forEach>
                        <tr>
                          <td height="30" colspan="2"><div align="right" class="productname">
                            <table width="100%" border="0" cellspacing="0" cellpadding="2">
                              <tr>
                                <td width="100%" height="100%"><div align="right">Total</div></td>
                              </tr>
                            </table>
                          </div></td>
                          <td width="30%" height="30" bgcolor="#FFFF00"><div align="right" class="productname"><fmt:formatNumber value="${total}" currencySymbol="Rp " type="currency"/></div></td>
                        </tr>
                      </table>
                      </td>
                    </tr>
                    <tr>
                      <td height="30">&nbsp;</td>
                    </tr>
                    <tr>
                      <td height="30"><div align="right">
                        <form id="form1" name="form1" method="post" action="controller?page=register">
                          <label>
                          <div align="center">
                            <input type="submit" name="button" id="button" value="Checkout" />
                          </div>
                          </label>
                         </form>
                        </div></td>
                    </tr>
                  </table>
                  </c:if>
                  <c:if test="${cart==null}">
                    <div align="center" class="productname">Your Cart is Still Empty!!!</div>
                 </c:if>
              </td>
            </tr>
          </table></td>
        </tr>
      </table>
    </div>
    </body>
</html>

