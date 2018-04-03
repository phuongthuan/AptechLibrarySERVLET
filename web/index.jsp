<%-- 
    Document   : index
    Created on : Mar 29, 2018, 6:22:40 PM
    Author     : PHUONGTHUAN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.alb.entities.*" %>
<%@page import="com.alb.beans.*" %>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.alb.i18n.language" />

<!DOCTYPE html>
<c:if test="${sessionScope.username==null}">
    <jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<html lang="${language}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <center>
            <h1>APTECH LIBRARY!!</h1>
            <p>
                Welcome, <b>${sessionScope.username}</b>
                <a href="LogoutController">
                Logout</a>
                </label>
            </p>
            
            <b><a style="color: blue; text-decoration: none" href="addnewbook.jsp">New Book</a></b>
            <table class="mytable">
                <tr>
                    <td><b><label for="no"><fmt:message key="index.label.no" /></label></b></td>
                    <td><b><label for="bookname"><fmt:message key="index.label.name" /></label></b></td>
                    <td><b><label for="category"><fmt:message key="index.label.category" /></label></b></td>
                    <td><b><label for="author"><fmt:message key="index.label.author" /></label></b></td>
                    <td><b><label for="publisher"><fmt:message key="index.label.publisher" /></label></b></td>
                    <td><b><label for="status"><fmt:message key="index.label.status" /></label></b></td>
                    <td><b><label for="created"><fmt:message key="index.label.created" /></label></b></td>
                    <td><b><label for="updated"><fmt:message key="index.label.updated" /></label></b></td>
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
                                <fmt:message key="index.button.detail" var="detailButton" />
                                <input type="submit" name="detail" value="${detailButton}">
                                <input type="hidden" name="bookId" value="${book.id}">
                            </form>
                        </td>
                        
                        <td>
                            <form method="POST" action="DeleteBookController" onsubmit="return confirm('Are you sure want to delete?');">
                                <fmt:message key="index.button.delete" var="deleteButton" />
                                <input type="submit" name="delete" value="${deleteButton}">
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
