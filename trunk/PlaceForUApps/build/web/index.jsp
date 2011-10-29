<%-- 
    Document   : index
    Created on : Oct 29, 2011, 1:26:33 PM
    Author     : Widiasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Login Member</h2>
        <form method='post' action='login'>
        <fieldset>
        Username:
        <input type='text' name='uname' />
        <br><br>
        Password:
        <input type='password' name='pass' />
        <br><br>
        <input type='submit' value='Login' />
        </fieldset>
        <a href="/PlaceForUApps/register.jsp">Register</a>
        </form>
    </body>
</html>

