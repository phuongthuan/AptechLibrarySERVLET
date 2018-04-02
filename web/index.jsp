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
            <h4>Welcome ${sessionScope.username}</h4>
            <b><a style="color: blue; text-decoration: none" href="addnewbook.jsp">New Book</a></b>
            <table class="mytable">
                <tr>
                    <td><b>No</b></td>
                    <td><b>Title</b></td>
                    <td><b>Category</b></td>
                    <td><b>Author</b></td>
                    <td><b>Publisher</b></td>
                    <td><b>Status</b></td>
                    <td><b>Date Borrowed</b></td>
                    <td><b>Date Returned</b></td>
                    <td><b></b></td>
                </tr>
                <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="request"/>
                <c:forEach items="${controller.allBooks}" var="book" >
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.category.name}</td>
                        <td>${book.author.name}</td>
                        <td>${book.publisher.name}</td>
                        <c:choose>
                            <c:when test="${book.status.id == 1}">
                                <td><b style="color: red">Borrowed</b></td>
                            </c:when>
                            <c:when test="${book.status.id == 2}">
                                <td><b style="color: green">Returned</b></td>
                            </c:when>
                            <c:otherwise>
                                <td><b style="color: greenyellow">Available</b></td>
                            </c:otherwise>
                        </c:choose>
                        <td>${book.created_at}</td>
                        <td>${book.updated_at}</td>
                        
                        <td>
                            <form method="GET" action="ReadBookController">
                                <input type="submit" value="Detail">
                                <input type="hidden" name="bookId" value="${book.id}">
                            </form>
                        </td>
                        
                        <td>
                            <form method="POST" action="DeleteBookController" onsubmit="return confirm('Are you sure want to delete?');">
                                <input type="submit" value="Delete">
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
