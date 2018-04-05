<%-- 
    Document   : history
    Created on : Apr 5, 2018, 2:13:54 PM
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
        <title>History</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <center>
            <table class="mytable">
                <h1>Lịch Sử</h1>
                <a href="index.jsp">Home</a>

                <tr>
                    <td><b><label for="no"><fmt:message key="index.label.no" /></label></b></td>
                    <td><b><label for="bookId"><fmt:message key="index.label.book_id" /></label></b></td>
                    <td><b><label for="student"><fmt:message key="index.label.student" /></label></b></td>
                    <td><b><label for="created"><fmt:message key="index.label.created" /></label></b></td>
                    <td><b><label for="updated"><fmt:message key="index.label.updated" /></label></b></td>
                    <td><b></b></td>
                </tr>
                <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="request"/>
                <c:forEach items="${controller.allHistories}" var="h" >
                    <tr>
                        <td>${h.id}</td>
                        <td>${h.book_id}</td>
                        <td>${h.student_name}</td>
                        <td>${h.created_at}</td>
                        <td>${h.updated_at}</td>
                        
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
