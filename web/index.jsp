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
    </head>
    <body>
        <h1>LIBRARY!!</h1>
        <table style="border: solid black">
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
            <c:forEach items="${controller.listBook}" var="book" >
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.description}</td>
                    <td>${book.category_id}</td>
                    <td>${book.author_id}</td>
                    <td>${book.publisher_id}</td>
                    <td>${book.status}</td>
                    <td>
                        <form method="POST" action="DeleteBookController">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="bookId" value="${book.id}">
                        </form>
                    </td>
                    
                    <td>
                        <form method="POST" action="ReadBookController">
                            <input type="submit" value="Detail">
                            <input type="hidden" name="bookId" value="${book.id}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a style="color: blue" href="addnewbook.jsp">Add New Book</a>
    </body>
    
    
</html>
