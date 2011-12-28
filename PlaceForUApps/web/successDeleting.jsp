<%-- 
    Document   : Registration Confirmation 
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Ika
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
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
    <div id="logo">
	<h1>PlaceForU</h1>
	<p>Cara Cepat Sewa Tempat dengan Cepat</p>
    </div>
<div id="page">
	<div>
		<div id="content">
			<div class="post">
				<div class="entry">
                                    <p><font color="red"><%=  request.getAttribute("message")  %></font></p>
                                    
                                    <a href="<%=  request.getAttribute("page")  %>">Kembali</a>
               
				</div>
			</div>
			
		</div>
         </div>	
</div>
<div id="footer">
	<p>Design by Kelompok 9</p>
</div>
</div>
<!-- end #footer -->
</body>
</html>

