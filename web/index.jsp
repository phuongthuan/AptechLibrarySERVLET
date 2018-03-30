<%-- 
    Document   : index
    Created on : Mar 29, 2018, 6:22:40 PM
    Author     : PHUONGTHUAN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.alb.entities.*" %>
<%@page import="com.alb.beans.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <h1>LIBRARY!!</h1>
        <table class="mytable">
            <tr>
                <th>No</th>
                <th><a style="text-decoration: none" href="book.jsp">Title</a></th>
                <th>Description</th>
                <th><a style="text-decoration: none" href="category.jsp">Category</a></th>
                <th><a style="text-decoration: none" href="author.jsp">Author</a></th>
                <th><a style="text-decoration: none" href="publisher.jsp">Publisher</a></th>
                <th>Status</th>
                <th>Option</th>
            </tr>
            <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="page"/>
            <c:forEach items="${controller.allBooks}" var="book" >
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.description}</td>
                    <td>${book.category.name}</td>
                    <td>${book.author.name}</td>
                    <td>${book.publisher.name}</td>
                    <td>${book.status.name}</td>
                    <td>
                        <form method="POST" action="DeleteBookController">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="bookId" value="${book.id}">
                        </form>
                    </td>
                    
                    <td><a style="text-decoration: none" href="bookdetail.jsp?id=${book.id}">Detail</a></td>
                </tr>
            </c:forEach>
        </table>
        <a style="color: blue" href="addnewbook.jsp">Add New Book</a>
    </body>
    
    
</html>
