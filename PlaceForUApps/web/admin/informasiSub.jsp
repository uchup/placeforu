<%-- 
    Document   : informasiSub
    Created on : Dec 25, 2011, 7:01:29 PM
    Author     : Yuni
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
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
			<li class="current_page_item"><a href="DaftarPengguna">Manajemen User</a></li>
                        <li class="current_page_item"><a href="ListGedung">Manajemen Gedung</a></li>
                        <li class="current_page_item"><a href="HistoriSewa">Manajemen Penyewaan</a></li>
                        <li class="current_page_item"><a href="HistoriAdministrasi">Manajemen Administrasi</a></li>
                        <li class="current_page_item"><a href="logout">Logout</a></li>
		</ul>
                </div>
                <div id="gallery"><img src="images/img03.jpg" width="692" height="340" alt="" /></div>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="content">
                        <div class="post">
                            <h2 class="title"><a href="#">Detail Informasi Sub Gedung</a></h2>
                            <p class="meta"><span class="date"><% new Date();%></span><span class="posted">Posted by <a href="#"></a></span></p>
                            <div style="clear: both;">&nbsp;</div>
                            <div class="entry"><h1>${subgedung.nama_sub_gedung}</h1>
                                <div class="page-big-image"><img src="sub/${subgedung.foto1}" alt="" id="page-big-image"></div>
<div class="clear"></div>
                              <div class="page-info-table">
                                <fieldset>
                                    <form method='post'>
                                        <table>
                                            <tr>
                                                <td>
                                                    <fieldset>
                                                        <legend><h4>Informasi Sub Gedung</h4></legend>
                                                        <table>
                                                            <tr>
                                                                <td>Nama SubGedung </td>
                                                                <td>:</td>
                                                                <td>${subgedung.nama_sub_gedung}</td>
                                                                <td></td>
                                                                <td></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Tipe Sub Gedung</td>
                                                                <td>:</td>

                                                                <td>
                                                                    ${subgedung.tipe_sub_gedung}
                                                                </td>
                                                                <td></td>
                                                                <td></td>
                                                            </tr>
                                                            <tr><td>Harga Sewa /jam</td>
                                                                <td>:</td>
                                                                <td>${subgedung.harga}

                                                                    Satuan
                                                                    :
                                                                    ${subgedung.satuan}
                                                                </td>
                                                            </tr>
                                                            <tr><td>Kapasitas</td>
                                                                <td>:</td>
                                                                <td>${subgedung.kapasitas} orang</td>
                                                            </tr>
                                                            <tr><td>Luas </td>
                                                                <td>:</td>
                                                                <td>${subgedung.luas} meter persegi</td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    Fasilitas Sub Gedung
                                                                </td>
                                                                <td>:</td>
                                                                <td>
                                                                    ${subgedung.fasilitas_sub}
                                                                </td>
                                                            </tr>


                                                            <tr>
                                                                <td>
                                                                    Deskripsi Sub Gedung
                                                                </td>
                                                                <td>:</td>
                                                                <td>
                                                                    ${subgedung.deskripsi_sub}
                                                                </td>
                                                            </tr>
                                                            <tr><td>Status Sewa </td>
                                                                <td>:</td>
                                                                <td>
                                                                    ${subgedung.status}
                                                                </td>
                                                            </tr>

                                                            <tr>


                                                                <td><a href="EditSubGedung?idsub=${subgedung.id}">Edit</a></td>
                                                            </tr>


                                                        </table>

                                                    </fieldset>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                </fieldset>
                              </div>
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
                                <h2>Blogroll</h2>
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
                                <h2>Blogroll</h2>
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
