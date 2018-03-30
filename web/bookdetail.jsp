<%-- 
    Document   : bookdetail
    Created on : Mar 30, 2018, 12:23:13 AM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Detail</title>
    </head>
    <body>
        <h1>Details ID ${sessionScope.bookId}</h1>
        <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="page"/>

        <c:out value="${controller.getBookById(sessionScope.bookId)}"></c:out><br />
        
        <a style="color: red" href="index.jsp">Home</a>
    </body>
</html>
