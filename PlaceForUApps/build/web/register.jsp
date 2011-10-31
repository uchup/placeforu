<%-- 
    Document   : register
    Created on : Oct 29, 2011, 4:12:16 PM
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
        <h2>Pendaftaran User</h2>
         <form method='post' action='register'>
        <fieldset>
        Nama            :
        <input type='text' name='nama' />
        <br><br>
        tipe pengguna :
        <input type='text' name='tipe' />
        <br><br>
        Email:
        <input type='text' name='email' />
        <br><br>
        Alamat:
        <input type='text' name='alamat' />
        <br><br>
        No.Hp:
        <input type='text' name='hape' />
        <br><br>
        No.Telp:
        <input type='text' name='telp' />
        <br><br>
        Username:
        <input type='text' name='usname' />
        <br><br>
        Password:
        <input type='password' name='psword' />
        <br><br>
        <input type='submit' value='Daftar' />
        </fieldset>
        </form>
    </body>
</html>
