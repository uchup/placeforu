<%--
    Document   : index
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Yuni
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="entity.SubGedung"%>


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
                        <li class="current_page_item"><a href="admin">Home</a></li>
			<li class="current_page_item"><a href="ListGedung">Manajemen Gedung</a></li>
                        <li class="current_page_item"><a href="HistoriSewa">Manajemen Penyewaan</a></li>
                        <li class="current_page_item"><a href="HistoriAdministrasi">Manajemen Administrasi</a></li>
                        <li class="current_page_item"><a href="DaftarPengguna">Manajemen User</a></li>
                        <li class="current_page_item"><a href="logout">Logout</a></li>
                    </ul>
                </div>
                <div id="gallery"><img src="images/img03.jpg" width="692" height="340" alt="" /></div>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="content">
                        <div class="post">
                            <h2 class="title"><a href="#">Daftar Sub Gedung</a></h2>
                            <p class="meta"><span class="date"><% new Date();%></span><span class="posted">Posted by <a href="#">Administrator</a></span></p>
                            <div style="clear: both;">&nbsp;</div>
                            <div class="entry">
                                <form method='post' action=''>
                                    <table>
                                        <tr>
                                            <td>ID Gedung</td>

                                            <td>ID Sub Gedung</td>
                                            <td>Nama Sub Gedung</td>
                                            <td>Tipe Sub Gedung</td>
                                            <td>Status</td>
                                            <td>Lihat</td>
                                            <td>Ubah / Hapus </td>
                                        </tr>
                                        <%Iterator itr;%>
                                        <% List subgedung_list = (List) request.getAttribute("gedung");
                                            for (itr = subgedung_list.iterator(); itr.hasNext();) {
                                                entity.SubGedung subgedung = (entity.SubGedung) itr.next();
                                        %>
                                        <tr>
                                            <input type="hidden" name="id_gedung" value="<%=subgedung.getId_gedung()%>">
                                            <td><%=subgedung.getId_gedung()%></td>
                                            <input type="hidden" name="id_sub_gedung" value="<%=subgedung.getId()%>">
                                            <td><%=subgedung.getId()%></td>
                                            <td><%=subgedung.getNama_sub_gedung()%></td>
                                            <td><%=subgedung.getTipe_sub_gedung()%></td>
                                            <td><%=subgedung.getStatus()%></td>
                                            <td><a href="DetailSubGedungPemilik?idsub=<%=subgedung.getId()%>">Detail</a></td>
                                            <td><a href="EditSubGedung?idsub=<%=subgedung.getId()%>">Ubah</a> / <a href="HapusSub?idsub=<%=subgedung.getId()%>">Hapus</a></td>

                                                    <%}%>
                                                    </table>
                                                    </form>
                                                    </div>
                                                    </div>

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
                                                                <h2> </h2>

                                                                <fieldset>
                                                                    <table>
<%SubGedung sg = new SubGedung ();%>

                                                                        <tr>
                                                                            <td><a href="TambahSubGedung?id=${gd.id}">Tambah Sub Gedung</a></td>

                                                                        </tr>

                                                                    </table>
                                                                </fieldset>

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

