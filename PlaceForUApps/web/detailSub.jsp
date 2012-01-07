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
                            <div class="inside">
                                <div style="clear: both;">&nbsp;</div>
                                <div class="entry">
                                    <h1> Detail Informasi Gedung ${subgedung.nama_sub_gedung}</h1>
                                </div>
                                <br>
                                <div class="page-info-table">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tbody><tr>
                                                <th colspan="3">Informasi Umum</th>
                                            </tr>
                                            <tr>
                                                <td width="25%">Tipe Sub Gedung</td>
                                                <td width="2%">:</td>
                                                <td>${subgedung.tipe_sub_gedung}</td>
                                            </tr>
                                            <tr>
                                                <td width="20%">Harga Sewa /jam</td>
                                                <td width="2%">:</td>
                                                <td>${subgedung.harga}  ${subgedung.satuan}</td>
                                            </tr>
                                            <tr>
                                                <td>Kapasitas</td>
                                                <td>:</td>
                                                <td>${subgedung.kapasitas} orang</td>
                                            </tr>
                                            <tr>
                                                <td>Luas </td>
                                                <td>:</td>
                                                <td>${subgedung.luas} meter persegi</td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th colspan="3">Keterangan Lengkap</th>
                                            </tr>
                                            <tr>
                                                <td>Deskripsi Sub Gedung</td>
                                                <td>:</td>
                                                <td>${subgedung.deskripsi_sub}</td>
                                            </tr>
                                            <tr>
                                                <td>Fasilitas Sub Gedung</td>
                                                <td>:</td>
                                                <td>${subgedung.fasilitas_sub}</td>
                                            </tr>
                                            <tr>
                                                <td>Status Sub Gedung</td>
                                                <td>:</td>
                                                <td>${subgedung.status}</td>
                                            </tr>
                                            <tr>
                                            <tr>
                                                <td colspan="3">&nbsp;</td>
                                            </tr>
                                        </tbody></table>
                                    <br>
                                    <a href="javascript:history.go(-1)" onMouseOver="self.status=document.referrer;return true">Kembali</a>
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

