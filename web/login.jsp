<%-- 
    Document   : login
    Created on : Apr 2, 2018, 4:43:04 PM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.alb.i18n.language" />
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="login.title.name"/></title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="vni" ${language == 'vni' ? 'selected' : ''}>Tiếng Việt</option>
            </select>
        </form>
        <center>

            <form action="LoginController" method="POST">

                <table class="mytable">
                    <tr>
                        <td></td>
                        <td><h2><label for="titlename"><fmt:message key="login.title.name"/></label></h2></td>
                    </tr>
                    <tr>
                        <td><label for="username"><fmt:message key="login.label.username"/>:</label></td>
                        <td><input type="text" id="username" name="username" required/></td>
                    </tr>
                    <tr>
                        <td><label for="password"><fmt:message key="login.label.password"/>:</label></td>
                        <td><input type="password" id="password" name="password" required/></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <fmt:message key="login.button.submit" var="buttonValue"/>
                            <input type="submit" style="color: blue" value="${buttonValue}" name="submit"/>
                        </td>
                    </tr>
                </table>

            </form>
                                
        </center>
    </body>
</html>

