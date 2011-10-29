<%-- 
    Document   : coba
    Created on : Oct 26, 2011, 9:52:51 PM
    Author     : Yuni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean type="entity.User" id="key" scope="request" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:getProperty name ="key" property="username" />
    </body>
</html>
