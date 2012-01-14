<%--
    Document   : index
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Yuni
--%>

<%@page import="entity.DaftarSubGedung"%>
<%@page import="entity.DaftarGedung"%>
<%@page import="entity.Gedung"%>
<%@page import="entity.DaftarUser"%>
<%@page import="entity.DaftarSewa"%>
<%@page import="entity.Sewa"%>
<%@page import="entity.User"%>
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
                        <li class="current_page_item"><a href="pemilik/profil">Profil</a></li>
                        <li class="current_page_item"><a href="ListGedung">Manajemen Gedung</a></li>
                        <li class="current_page_item"><a href="HistoriSewa">Manajemen Penyewaan</a></li>
                        <li class="current_page_item"><a href="HistoriAdministrasi">Manajemen Administrasi</a></li>
                        <li class="current_page_item"><a href="logout">Log Out</a></li>
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
                                <form method='post'>
                                    <p> <b>Histori Pembayaran (Telah Terkonfirmasi)</b></p>
                                    <table>
                                        <tr>
                                            <td>ID Sewa</td>
                                            <td>Penyewa</td>
                                            <td>Nama Gedung</td>
                                            <td>Nama SubGedung</td>
                                            <td>Tanggal Pembayaran</td>
                                            <td>Total Pembayaran</td>
                                            <td>Sisa Pembayaran</td>
                                            <td>Jumlah Pembayaran</td>

                                        </tr>
                                        <%Iterator itr;%>
                                        <% List adm_list = (List) request.getAttribute("pemilik_1");
                                                    for (itr = adm_list.iterator(); itr.hasNext();) {
                                                        entity.Administrasi adm = (entity.Administrasi) itr.next();
                                        %>
                                        <tr>
                                            <td><%=adm.getIdSewa()%></td>
                                            <%
                                                                                            entity.Sewa s = new Sewa();
                                                                                            entity.DaftarSewa ds = new DaftarSewa();
                                                                                            Long idSewa = adm.getIdSewa();
                                                                                            s = ds.getSewaFromId(idSewa);
                                                                                            Long idPenyewa = s.getIdPenyewa();
                                                                                            entity.User u = new User();
                                                                                            entity.DaftarUser du = new DaftarUser();
                                                                                            u = du.getUserFromId(idPenyewa);
                                                                                            String namaPenyewa = u.getNama();
                                                                                            String totalBayar = Integer.toString(s.getTotalHargaSewa());
                                                                                            String sisaBayar = Integer.toString(s.getSisaBayar());
                                            %>
                                            <td><%out.println(namaPenyewa);%></td>
                                            <%
                                                                                            Long idGedung = s.getIdGedung();
                                                                                            entity.Gedung gd = new Gedung();
                                                                                            entity.DaftarGedung dg = new DaftarGedung();
                                                                                            gd = dg.getGedung(idGedung);
                                                                                            String namaGedung = gd.getNamaGedung();
                                            %>
                                            <td><%out.println(namaGedung);%></td>
                                            <%
                                                                                            Long idSubGedung = s.getIdSubGedung();
                                                                                            entity.SubGedung sgd = new SubGedung();
                                                                                            entity.DaftarSubGedung dsg = new DaftarSubGedung();
                                                                                            sgd = dsg.getSubGedung(idSubGedung);
                                                                                            String namaSubGedung = sgd.getNama_sub_gedung();
                                            %>
                                            <td><%out.println(namaSubGedung);%></td>
                                            <td><%=adm.getTglBayar()%></td>
                                            <td><%out.println(totalBayar);%></td>
                                            <td><%out.println(sisaBayar);%></td>
                                            <td><%=adm.getJumlahBayar()%></td>
                                        </tr>

                                        <%}%>
                                    </table>
                                    <br><br>
                                    <p><b> Histori Pembayaran (Menunggu Persetujuan)</b></p>
                                    <table>
                                        <tr>
                                            <td>ID Sewa</td>
                                            <td>Penyewa</td>
                                            <td>Nama Gedung</td>
                                            <td>Nama SubGedung</td>
                                            <td>Tanggal Pembayaran</td>
                                            <td>Sisa Pembayaran</td>
                                            <td>Jumlah Pembayaran</td>
                                            <td></td>
                                        </tr>
                                        <%Iterator itr2;%>
                                        <% List adm2_list = (List) request.getAttribute("pemilik_0");
                                                    for (itr2 = adm2_list.iterator(); itr2.hasNext();) {
                                                        entity.Administrasi adm2 = (entity.Administrasi) itr2.next();
                                        %>
                                        <tr>
                                            <td><%=adm2.getIdSewa()%></td>
                                            <%
                                                                                            entity.Sewa s = new Sewa();
                                                                                            entity.DaftarSewa ds = new DaftarSewa();
                                                                                            Long idSewa = adm2.getIdSewa();
                                                                                            s = ds.getSewaFromId(idSewa);
                                                                                            Long idPenyewa = s.getIdPenyewa();
                                                                                            entity.User u = new User();
                                                                                            entity.DaftarUser du = new DaftarUser();
                                                                                            u = du.getUserFromId(idPenyewa);
                                                                                            String namaPenyewa = u.getNama();
                                                                                            String totalBayar = Integer.toString(s.getTotalHargaSewa());
                                                                                            String sisaBayar = Integer.toString(s.getSisaBayar());
                                            %>
                                            <td><%out.println(namaPenyewa);%></td>
                                            <%
                                                                                            Long idGedung = s.getIdGedung();
                                                                                            entity.Gedung gd = new Gedung();
                                                                                            entity.DaftarGedung dg = new DaftarGedung();
                                                                                            gd = dg.getGedung(idGedung);
                                                                                            String namaGedung = gd.getNamaGedung();
                                            %>
                                            <td><%out.println(namaGedung);%></td>
                                            <%
                                                                                            Long idSubGedung = s.getIdSubGedung();
                                                                                            entity.SubGedung sgd = new SubGedung();
                                                                                            entity.DaftarSubGedung dsg = new DaftarSubGedung();
                                                                                            sgd = dsg.getSubGedung(idSubGedung);
                                                                                            String namaSubGedung = sgd.getNama_sub_gedung();
                                            %>
                                            <td><%out.println(namaSubGedung);%></td>
                                            <td><%=adm2.getTglBayar()%></td>
                                            <td><%out.println(sisaBayar);%></td>
                                            <td><%=adm2.getJumlahBayar()%></td>
                                            <td><a href="EditAdministrasi?id=<%=adm2.getId()%>">Terima Pembayaran</a></td>
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

