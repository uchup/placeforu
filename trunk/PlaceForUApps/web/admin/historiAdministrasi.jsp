
<%@page import="entity.DaftarUser"%>
<%@page import="entity.DaftarSewa"%>
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
<%@page import="entity.DaftarAdministrasi"%>
<%@page import="entity.Administrasi"%>


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
                            <h2 class="title"><a href="#">Histori Sewa</a></h2>
                            <p class="meta"><span class="date"><% new Date();%></span><span class="posted">Posted by <a href="#">Administrator</a></span></p>
                            <div style="clear: both;">&nbsp;</div>
                                <form method='post'>
                                    <h4><b>Histori Administrasi Sewa </b></h4>
                                    <table>
                                        <tr>
                                            <td>ID Sewa</td>
                                            <td>Gedung</td>
                                            <td>Sub Gedung</td>
                                            <td>Jumlah dibayar</td>
                                            <td>Tgl Bayar</td>
                                            <td>Penyewa</td>
                                            <td>Pemilik</td>
                                            <td></td>
                                        </tr>
                                        <%Iterator itr2;%>
                                        <% List sewa_list2 = (List) request.getAttribute("admin");
                                                    for (itr2 = sewa_list2.iterator(); itr2.hasNext();) {
                                                        entity.Administrasi adm = (entity.Administrasi) itr2.next();
                                        %>
                                        <tr>
                                            <td><%=adm.getIdSewa()%></td>
                                            <%
                                                                                                    entity.Sewa sw = new Sewa();
                                                                                                    entity.DaftarSewa ds = new DaftarSewa();
                                                                                                    sw = ds.getSewaFromId(adm.getIdSewa());

                                                                                                    entity.Gedung g = new Gedung();
                                                                                                    entity.DaftarGedung dg = new DaftarGedung();
                                                                                                    g = dg.getGedung(sw.getIdGedung());
                                                                                                    String namaGedung = g.getNamaGedung();

                                                                                                    entity.User u = new User();
                                                                                                    entity.DaftarUser du = new DaftarUser();
                                                                                                    u = du.getUserFromId(sw.getIdPemilik());
                                                                                                    String namaPemilik = u.getNama();

                                                                                                    entity.User u2 = new User();
                                                                                                    entity.DaftarUser du2 = new DaftarUser();
                                                                                                    u2 = du.getUserFromId(sw.getIdPenyewa());
                                                                                                    String namaPenyewa = u2.getNama();


                                            %>
                                            <td><%out.println(namaGedung);%></td>
                                            <%
                                                                                                    entity.SubGedung sg = new SubGedung();
                                                                                                    entity.DaftarSubGedung dgs = new DaftarSubGedung();

                                                                                                    sg = dgs.getSubGedung(sw.getIdSubGedung());
                                                                                                    String namaSubGedung = sg.getNama_sub_gedung();
                                            %>
                                            <td><%out.println(namaSubGedung);%></td>
                                            <td><%=adm.getJumlahBayar()%></td>
                                            <td><%=adm.getTglBayar()%></td>
                                            <td><%out.println(namaPemilik);%></td>
                                            <td><%out.println(namaPenyewa);%></td>
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

