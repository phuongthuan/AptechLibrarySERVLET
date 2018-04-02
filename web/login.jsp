<%-- 
    Document   : login
    Created on : Apr 2, 2018, 4:43:04 PM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <center>

            <form action="LoginController" method="POST">

                <table class="mytable">
                    <tr>
                        <td></td>
                        <td><h2>Login</h2></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" required/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" style="color: blue">Login</button>
                        </td>
                    </tr>
                </table>

            </form>
                                
        </center>
    </body>
</html>

