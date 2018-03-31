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
        <center>
            <h1>APTECH LIBRARY!!</h1>
            <b><a style="color: blue; text-decoration: none" href="addnewbook.jsp">New Book</a></b>
            <table class="mytable">
                <tr>
                    <td><b>No</b></td>
                    <td><b>Title</b></td>
                    <td><b>Description</b></td>
                    <td><b>Category</b></td>
                    <td><b>Author</b></td>
                    <td><b>Publisher</b></td>
                    <td><b>Status</b></td>
                    <td><b>Option</b></td>
                </tr>
                <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="request"/>
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
                            <form method="POST" action="DeleteBookController" onsubmit="return confirm('Are you sure want to delete?');">
                                <input type="submit" value="Delete">
                                <input type="hidden" name="bookId" value="${book.id}">
                            </form>
                        </td>
                        
                        <td>
                            <form method="GET" action="ReadBookController">
                                <input type="submit" value="Detail">
                                <input type="hidden" name="bookId" value="${book.id}">
                            </form>
                        </td>
                        
                        
                        <!--<td><a style="text-decoration: none" href="bookdetail.jsp?id=${book.id}">Detail</a></td>-->
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
