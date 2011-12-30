<%--
    Document   : index
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Ika
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
                        <ul>
                            <li class="current_page_item"><a href="ListGedung">Informasi Gedung</a></li>
                            <li class="current_page_item"><a href="penyewa/profil">Profil</a></li>
                            <li class="current_page_item"><a href="">Manajemen Penyewaan</a></li>
                            <li class="current_page_item"><a href="logout">Log Out</a></li>
                        </ul>
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
                                <form method='post' action="Sewa" name="formentry">
                                    <table>
                                        <input type="hidden" name="idGedung" value="${subgedung.id_gedung}">
                                        <input type="hidden" name="idSubGedung" value="${subgedung.id}">
                                        <input type="hidden" name="idPenyewa" value="${akun.id}">
                                        <input type="hidden" name="idPemilik" value="${subgedung.id_pemilik}">
                                        <tr>
                                            <td>No Akun</td>
                                            <td>:</td>
                                            <td><input type="text" name="idAkun" value="${akun.id}" readonly></td>
                                        </tr>
                                        <tr>
                                            <td>Nama Penyewa</td>
                                            <td>:</td>
                                            <td><input type="text" name="nama_penyewa" value="${akun.nama}" readonly></td>
                                        </tr>
                                        <tr>
                                            <td>Gedung Disewa</td>
                                            <td>:</td>
                                            <td><input type="text" name="nama_gedung" value="${gedung.namaGedung}" readonly></td>
                                        </tr>
                                        <tr>
                                            <td>Sub Gedung Disewa</td>
                                            <td>:</td>
                                            <td><input type="text" name="nama_sub_gedung" value="${subgedung.nama_sub_gedung}" readonly></td>
                                        </tr>
                                        <tr>
                                            <td>Harga Sewa</td>
                                            <td>:</td>
                                            <td><input type="text" name="harga" value="${subgedung.harga}" readonly> /hari</td>
                                        </tr>
                                        <tr>
                                            <td>Tanggal Sewa</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        
                                        <tr>
                                            <td>Mulai<font color="red">*</font></td>
                                            <td>:</td>
                                            <td><select name="tgl_mulai">
                                                    <option value="01">01</option>
                                                    <option value="02">02</option>
                                                    <option value="03">03</option>
                                                    <option value="04">04</option>
                                                    <option value="05">05</option>
                                                    <option value="06">06</option>
                                                    <option value="07">07</option>
                                                    <option value="08">08</option>
                                                    <option value="09">09</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                    <option value="13">13</option>
                                                    <option value="14">14</option>
                                                    <option value="15">15</option>
                                                    <option value="16">16</option>
                                                    <option value="17">17</option>
                                                    <option value="18">18</option>
                                                    <option value="19">19</option>
                                                    <option value="20">20</option>
                                                    <option value="21">21</option>
                                                    <option value="22">22</option>
                                                    <option value="23">23</option>
                                                    <option value="24">24</option>
                                                    <option value="25">25</option>
                                                    <option value="26">26</option>
                                                    <option value="27">27</option>
                                                    <option value="28">28</option>
                                                    <option value="29">29</option>
                                                    <option value="30">30</option>
                                                    <option value="31">31</option>
                                                </select>
                                                <select name="bln_mulai">
                                                    <option value="01">Januari</option>
                                                    <option value="02">Februari</option>
                                                    <option value="03">Maret</option>
                                                    <option value="04">April</option>
                                                    <option value="05">Mei</option>
                                                    <option value="06">Juni</option>
                                                    <option value="07">Juli</option>
                                                    <option value="08">Agustus</option>
                                                    <option value="09">September</option>
                                                    <option value="10">Oktober</option>
                                                    <option value="11">Nopember</option>
                                                    <option value="12">Desember</option>
                                                </select>
                                                <select name="thn_mulai">
                                                    <option value="2010">2010</option>
                                                    <option value="2011">2011</option>
                                                    <option value="2012">2012</option>
                                                    <option value="2013">2013</option>
                                                    <option value="2014">2014</option>                                                   
                                                </select> 
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>Sampai<font color="red">*</font></td>
                                            <td>:</td>
                                            <td>
                                                <select name="tgl_sampai">
                                                    <option value="01">01</option>
                                                    <option value="02">02</option>
                                                    <option value="03">03</option>
                                                    <option value="04">04</option>
                                                    <option value="05">05</option>
                                                    <option value="06">06</option>
                                                    <option value="07">07</option>
                                                    <option value="08">08</option>
                                                    <option value="09">09</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                    <option value="13">13</option>
                                                    <option value="14">14</option>
                                                    <option value="15">15</option>
                                                    <option value="16">16</option>
                                                    <option value="17">17</option>
                                                    <option value="18">18</option>
                                                    <option value="19">19</option>
                                                    <option value="20">20</option>
                                                    <option value="21">21</option>
                                                    <option value="22">22</option>
                                                    <option value="23">23</option>
                                                    <option value="24">24</option>
                                                    <option value="25">25</option>
                                                    <option value="26">26</option>
                                                    <option value="27">27</option>
                                                    <option value="28">28</option>
                                                    <option value="29">29</option>
                                                    <option value="30">30</option>
                                                    <option value="31">31</option>
                                                </select>
                                                <select name="bln_sampai">
                                                    <option value="01">Januari</option>
                                                    <option value="02">Februari</option>
                                                    <option value="03">Maret</option>
                                                    <option value="04">April</option>
                                                    <option value="05">Mei</option>
                                                    <option value="06">Juni</option>
                                                    <option value="07">Juli</option>
                                                    <option value="08">Agustus</option>
                                                    <option value="09">September</option>
                                                    <option value="10">Oktober</option>
                                                    <option value="11">Nopember</option>
                                                    <option value="12">Desember</option>
                                                </select>
                                                <select name="thn_sampai">
                                                    <option value="2010">2010</option>
                                                    <option value="2011">2011</option>
                                                    <option value="2012">2012</option>
                                                    <option value="2013">2013</option>
                                                    <option value="2014">2014</option>                                                   
                                                </select> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" value="Sewa"></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
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
                                        <%SubGedung sg = new SubGedung();%>

                                        <tr>


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

