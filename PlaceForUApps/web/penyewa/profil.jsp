<%--
    Document   : profil
    Created on : Nov 16, 2011, 6:44:34 PM
    Author     : Yuni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>PlaceForU - Cara Cepat Sewa Tempat dengan Cepat</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
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
                        <li class="current_page_item"><a href="../penyewa/profil">Profil</a></li>
                        <li class="current_page_item"><a href="../ListGedung">Informasi Gedung</a></li>
                        <li class="current_page_item"><a href="../HistoriSewa">Manajemen Penyewaan</a></li>
                        <li class="current_page_item"><a href="../HistoriAdministrasi">Manajemen Administrasi</a></li>
                        <li class="current_page_item"><a href="../logout">Log Out</a></li>
                    </ul>
                </div>
                <div id="gallery"><img src="../images/img03.jpg" width="692" height="340" alt="" /></div>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="content">
                        <div class="post">
                            <h2 class="title"><a href="#">Profil User</a></h2>
                            <div style="clear: both;">&nbsp;</div>
                            <div class="entry">
                                <fieldset>
                                    <form method='post'  action='editPenyewa'>
                                        <table>
                                            <tr>
                                                <td>
                                                    <fieldset>

                                                        <legend><h4>Profil</h4></legend>
                                                        <table>
                                                            <tr>
                                                                <td>Nama Lengkap</td>
                                                                <td>:</td>
                                                                <td>${penyewa.nama}</td>
                                                                <td rowspan=6> <img src="../foto/${penyewa.foto}" width="150" height="200" alt="" /></td>

                                                            </tr>
                                                            <tr>
                                                                <td>Tipe pengguna</td>
                                                                <td>:</td>
                                                                <td>Penyewa Tempat
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Email</td>
                                                                <td>:</td>
                                                                <td>${penyewa.email}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Alamat</td>
                                                                <td>:</td>
                                                                <td>${penyewa.alamat}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>No.Hp</td>
                                                                <td>:</td>
                                                                <td>${penyewa.hape}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>No.Telp</td>
                                                                <td>:</td>
                                                                <td>${penyewa.telp}</td>
                                                            </tr>
                                                        </table>
                                                    </fieldset>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <fieldset>
                                                        <legend><h4>Akun Pengguna</h4></legend>
                                                        <table>
                                                            <tr>
                                                                <td>Username</td>
                                                                <td>:</td>
                                                                <td>${penyewa.username}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Password</td>
                                                                <td>:</td>
                                                                <td>${penyewa.password}</td>
                                                            </tr>

                                                            <tr>


                                                                <td><a href="../penyewa/editprofil">Edit</a></td>
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
