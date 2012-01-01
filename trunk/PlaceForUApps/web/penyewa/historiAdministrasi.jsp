
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.DaftarGedung"%>
<%@page import="entity.Gedung"%>
<%@page import="entity.DaftarSubGedung"%>
<%@page import="entity.SubGedung"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="entity.SubGedung"%>
<%@page import="entity.Sewa"%>


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
                            <li class="current_page_item"><a href="HistoriSewa">Manajemen Penyewaan</a></li>
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
                            <h2 class="title"><a href="#">Histori Sewa</a></h2>
                            <p class="meta"><span class="date"><% new Date();%></span><span class="posted">Posted by <a href="#">Administrator</a></span></p>
                            <div style="clear: both;">&nbsp;</div>
                            <div class="entry">
                                <form method='post'>
                                    <p> <h4><b>Histori Penyewaan </b></h4></p>
                                    <table>
                                        <tr>
                                            <td>ID Sewa</td>
                                            <td>Gedung</td>
                                            <td>Sub Gedung</td>
                                            <td>Total Harga Sewa</td>
                                            <td>Sisa Bayar</td>

                                            <td></td>
                                        </tr>
                                        <%Iterator itr2;%>
                                        <% List sewa_list2 = (List) request.getAttribute("penyewa_1");
                                            for (itr2 = sewa_list2.iterator(); itr2.hasNext();) {
                                                entity.Sewa sewa = (entity.Sewa) itr2.next();
                                        %>
                                        <tr>
                                            <td><%=sewa.getIdSewa()%></td>
                                            <%
                                                entity.Gedung g = new Gedung();
                                                entity.DaftarGedung dg = new DaftarGedung();
                                                Long idGedung = sewa.getIdGedung();
                                                g = dg.getGedung(idGedung);
                                                String namaGedung = g.getNamaGedung();
                                            %>
                                            <td><%out.println(namaGedung);%></td>
                                            <%
                                                entity.SubGedung sg = new SubGedung();
                                                entity.DaftarSubGedung dgs = new DaftarSubGedung();
                                                Long idSubGedung = sewa.getIdSubGedung();
                                                sg = dgs.getSubGedung(idSubGedung);
                                                String namaSubGedung = sg.getNama_sub_gedung();
                                            %>
                                            <td><%out.println(namaSubGedung);%></td>
                                            <td><%=sewa.getTotalHargaSewa()%></td>
                                            <td><%=sewa.getSisaBayar()%></td>
                                            <td>
                                                <a href="AdministrasiBaru?idSewa=<%=sewa.getIdSewa()%>">Bayar</a>
                                            </td>
                                        </tr>
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

