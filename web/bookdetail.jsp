<%-- 
    Document   : bookdetail
    Created on : Mar 30, 2018, 12:23:13 AM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.alb.i18n.language" />
<!DOCTYPE html>
<c:if test="${sessionScope.username==null}">
    <jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<html lang="${language}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Book Detail</title>
    </head>
    <body>

    <center>
        <jsp:useBean id="controller" class="com.alb.beans.LibraryModelBean" scope="page"/>

        <a style="color: red" href="index.jsp">Home</a>

        <form action="UpdateBookController" method="POST">
        <table class="mytable">

            <tr>
                <td></td>
                <td><h2>Details</h2></td>
            </tr>

            <tr>
                <td><b></b></td>
                <td><input type="hidden" name="bookId" value="${sessionScope.bookId}" /></td>
            </tr>

            <tr>
                <td><b><label for="name"><fmt:message key="index.label.name" /></label></b></td>
                <td><input name="name" value="${controller.getBookById(sessionScope.bookId).name}" required/></td>
            </tr>
            
            <tr>
                <td><b><label for="description"><fmt:message key="index.label.description" /></label></b></td>
                <td>
                    <textarea rows="5" cols="22" name="description">${controller.getBookById(sessionScope.bookId).description}</textarea>
                </td> 
            </tr>
            <tr>
                <td><b><label for="category"><fmt:message key="index.label.category" /></label></b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).category.name}" /></td> 
                <td><input type="hidden" name="categoryId" value="${controller.getBookById(sessionScope.bookId).category.id}" /></td> 
            </tr>

            <tr>
                <td><b><label for="author"><fmt:message key="index.label.author" /></label></b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).author.name}" /></td> 
                <td><input type="hidden" name="authorId" value="${controller.getBookById(sessionScope.bookId).author.id}" /></td> 
            </tr>

            <tr>
                <td><b><label for="publisher"><fmt:message key="index.label.publisher" /></label></b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).publisher.name}" /></td> 
                <td><input type="hidden" name="publisherId" value="${controller.getBookById(sessionScope.bookId).publisher.id}" /></td> 
            </tr>

            <tr>
                <td><b><label for="status"><fmt:message key="index.label.status" /></label></b></td>
<!--                
                <c:choose>
                    <c:when test="${controller.getBookById(sessionScope.bookId).status.id == 1}">
                        <td><b style="color: red">Borrowed</b></td>
                    </c:when>
                    <c:when test="${controller.getBookById(sessionScope.bookId).status.id == 2}">
                        <td><b style="color: green">Returned</b></td>
                    </c:when>
                    <c:otherwise>
                        <td><b style="color: greenyellow">Available</b></td>
                    </c:otherwise>
                </c:choose>
                        -->
                <td>
                    <select name="statusId">
                        <jsp:useBean id="statusDb" class="com.alb.da.StatusDB" scope="page"/>

                        <option value="${controller.getBookById(sessionScope.bookId).status.id}" selected>${controller.getBookById(sessionScope.bookId).status.name}</option>
                        <c:forEach items="${statusDb.allStatuses}" var="s">
                            <option value="${s.id}">${s.name}</option>
                        </c:forEach>
                    </select>
                </td>

            </tr>

            <tr>
                <td><b><label for="created"><fmt:message key="index.label.created" /></label></b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).created_at}" /></td> 
            </tr>

            <tr>
                <td><b><label for="updated"><fmt:message key="index.label.updated" /></label></b></td>
                <td><c:out value="${controller.getBookById(sessionScope.bookId).updated_at}" /></td> 
            </tr>
            
            <tr>
                <td></td>
                <td>
                    <button type="submit" style="color: blue">Update</button>
                </td>
            </tr>

        </table>
        </form>

    </center>
</body>
</html>
