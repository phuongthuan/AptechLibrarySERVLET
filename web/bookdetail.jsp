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
        <link rel="stylesheet" href="css/style.css" />
        <title>Book Detail</title>
    </head>
    <body>
        
    <center>
        <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="page"/>
        
        <h1>Book Details</h1>
        <a style="color: red" href="index.jsp">Home</a>
        <br />
        
        <table class="mytable">
            
            <tr>
                <td><b>Book ID</b></td>
                <td><c:out value="${sessionScope.bookId}" /></th> 
            </tr>
            
            <tr>
                <td><b>Book Name</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).name}" /></th> 
            </tr>
            <tr>
                <td><b>Description</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).description}" /></td> 
            </tr>
            <tr>
                <td><b>Category</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).category.name}" /></td> 
            </tr>
            
            <tr>
                <td><b>Author</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).category.name}" /></td> 
            </tr>

            <tr>
              <td><b>Publisher</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).publisher.name}" /></td> 
            </tr>

            <tr>
              <td><b>Status</b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).status.name}" /></td> 
            </tr>
        </table>

    </center>
    </body>
</html>
