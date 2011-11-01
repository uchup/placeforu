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
        <title>Pendaftaran User</title>
    </head>
    <body>
        <h2>Pendaftaran User</h2>
        <form method='post' action='register'>
        <fieldset>

        <table>
            <tr>
                <td>
                <fieldset>
                <legend><h4>Profil</h4></legend>    
                    <table>   
                        <tr>
                            <td>Nama</td>
                            <td>:</td>
                            <td><input type='text' name='nama' /></td>
                        </tr>
                        <tr>
                            <td>Tipe pengguna</td>
                            <td>:</td>
                            <td>
                                <select name="tipe">
                                    <option value="1">Pemilik Tempat</option>
                                    <option value="2">Penyewa Tempat</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>:</td>
                            <td><input type='text' name='email' /></td>
                        </tr>
                        <tr>
                            <td>Alamat</td>
                            <td>:</td>
                            <td><input type='text' name='alamat' /></td>
                        </tr>
                        <tr>
                            <td>No.Hp</td>
                            <td>:</td>
                            <td><input type='text' name='hape' /></td>
                        </tr>       
                        <tr>
                            <td>No.Telp</td>
                            <td>:</td>
                            <td><input type='text' name='telp' /></td>
                        </tr>
                        <tr>
                            <td>Foto</td>
                            <td>:</td>
                            <td><input type='file' name='foto' /></td>
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
                        <td><input type='text' name='usname' /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>:</td>
                        <td><input type='password' name='psword' /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><input type='submit' value='Register' /></td>
                    </tr>
                    </table> 
                    </fieldset>
                </table>
                </fieldset>
            </td>
        </tr>

        </form>
    </body>
</html>
