<%--
    Document   : index
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Widiasa
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="entity.DaftarGedung"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>PlaceForU - Cara Cepat Sewa Tempat dengan Cepat</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="logo">
                <h1>PlaceForU</h1>
                <p>Cara Cepat Sewa Tempat dengan Cepat</p>
            </div>
            <div id="header">
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="#">Homepage</a></li>
                    </ul>
                </div>
                <div id="gallery"><img src="images/img03.jpg" width="692" height="340" alt="" /></div>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="content">
                        <div class="post">
                            <h2 class="title"><a href="#">Selamat Datang di PlaceForU</a></h2>
                            <div style="clear: both;">&nbsp;</div>
                            <div class="entry">
                                <p> <strong>PlaceForU</strong>, merupakan aplikasi berbasis web yang dirancang untuk memudahkan Anda dalam mencari dan menyewa tempat untuk momen spesial Anda. </p><p><strong>Daftar segera dan rasakan kemudahannya!</strong></p>
                            </div>
                        </div>
                        <h1 class="title">
                            Daftar Gedung
                        </h1>
                        <ul class="listing">
                            <%Iterator itr;%>
                            <%entity.DaftarGedung dg = new entity.DaftarGedung();%>
                            <% List gedung_list = (List) request.getAttribute("gedung");
                                        if (dg.cekGedung()) {
                                            for (itr = gedung_list.iterator(); itr.hasNext();) {
                                                entity.Gedung gedung = (entity.Gedung) itr.next();
                            %>
                            <li>
                                <div class="listinfo">
                                    <img src="images/imageholder2.jpg" alt="Listing Image" class="listingimage" />
                                    <h3><%=gedung.getNamaGedung()%></h3>
                                    <p><%=gedung.getDeskripsiGedung()%></p>
                                    Harga Sewa: <span class="price">Rp0 </span>
                                </div>
                                <div class="listingbtns">
                                    <span class="listbuttons">
                                        <a href="DetailGedung?idgedung=<%=gedung.getId()%>">Lihat Detail</a>
                                    </span>
                                    <span class="listbuttons">
                                        <a href="ListSubGedungUmum?id=<%=gedung.getId()%>">Lihat Subgedung</a>
                                    </span></div>
                                <div class="clear">&nbsp;</div>
                            </li>
                            <%}%>
                        </ul>
                    </div>
                    <div id="sidebar">
                        <ul>
                            <li>
                                <div id="search" >
                                    <form method="get" action="#">
                                        <div>
                                            <input type="text" name="s" id="search-text" value="" />
                                            <input type="submit" id="search-submit" value="GO" />
                                        </div>
                                    </form>
                                </div>
                                <div style="clear: both;">&nbsp;</div>
                            </li>
                            <li>
                                <h2>Log In</h2>
                                <form method='post' action='login'>
                                    <fieldset>
                                        <table>
                                            <tr>
                                                <td>Username :</td>
                                            </tr>
                                            <tr>
                                                <td><input type='text' name='uname' /></td>
                                            </tr>
                                            <tr>
                                                <td>Password :</td>
                                            </tr>
                                            <tr>
                                                <td><input type='password' name='pass' /></td>
                                            </tr>
                                            <tr>
                                                <td><input type='submit' value='Login' />
                                                    <a href="register">Register</a></td>
                                            </tr>
                                        </table>
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <h2>Gedung Terbaru</h2>
                                <ul>
                                    <li><a href="#">Aliquam libero</a></li>
                                    <li><a href="#">Consectetuer adipiscing elit</a></li>
                                    <li><a href="#">Metus aliquam pellentesque</a></li>
                                    <li><a href="#">Suspendisse iaculis mauris</a></li>
                                    <li><a href="#">Urnanet non molestie semper</a></li>
                                    <li><a href="#">Proin gravida orci porttitor</a></li>
                                </ul>
                            </li>
                            <li>
                                <h2>Gedung Terlaris</h2>
                                <ul>
                                    <li><a href="#">Aliquam libero</a></li>
                                    <li><a href="#">Consectetuer adipiscing elit</a></li>
                                    <li><a href="#">Metus aliquam pellentesque</a></li>
                                    <li><a href="#">Suspendisse iaculis mauris</a></li>
                                    <li><a href="#">Urnanet non molestie semper</a></li>
                                    <li><a href="#">Proin gravida orci porttitor</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="footer-bg">
                <div id="footer-content">
                    <div id="col1">
                        <ul class="style1">
                            <li><a href="#">Etiam malesuada rutrum enim</a></li>
                            <li><a href="#">Aenean elementum facilisis ligula</a></li>
                            <li><a href="#">Ut tincidunt elit vitae augue</a></li>
                        </ul>
                    </div>
                    <div id="col2">
                        <ul class="style1">
                            <li><a href="#">Etiam malesuada rutrum enim</a></li>
                            <li><a href="#">Aenean elementum facilisis ligula</a></li>
                            <li><a href="#">Ut tincidunt elit vitae augue</a></li>
                        </ul>
                    </div>
                    <div id="col3">
                        <ul class="style1">
                            <li><a href="#">Etiam malesuada rutrum enim</a></li>
                            <li><a href="#">Aenean elementum facilisis ligula</a></li>
                            <li><a href="#">Ut tincidunt elit vitae augue</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="footer">
                <p>Copyright (c) 2011 PlaceForU.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/">CSS Templates</a> & PlaceForU Team.</p>
            </div>
        </div>
        <!-- end #footer -->
    </body>
</html>

