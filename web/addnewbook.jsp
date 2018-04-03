<%-- 
    Document   : addnewbook
    Created on : Mar 30, 2018, 12:51:22 AM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.username==null}">
    <jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
        <link rel="stylesheet" href="css/style.css" />

    </head>
    <body>
        <center>
            <B><a href="index.jsp" style="color: red" >Home</a></B>

            <form action="CreateBookController" method="POST">

                <table class="mytable">

                    <tr>
                        <td></td>
                        <td><h2>Insert</h2></td>
                    </tr>

                    <tr>
                        <td>Book Name:</td>
                        <td>
                            <input type="text" name="name" required/>
                        </td>
                    </tr>

                    <tr>
                        <td>Description</td>
                        <td>
                            <textarea name="description" rows="5" cols="22"></textarea>
                        </td>
                    </tr>

                    <tr>
                      <td>Category</td>
                      <td>
                            <select name="categoryId">
                                <jsp:useBean id="categoryDB" class="com.alb.da.CategoryDB" scope="page"/>
                                <c:forEach items="${categoryDB.allCategories}" var="c">
                                    <option value="${c.id}">${c.name}</option>
                                </c:forEach>
                            </select>
                      </td>
                    </tr>

                    <tr>
                        <td>Author</td>
                        <td>
                            <select name="authorId">
                                <jsp:useBean id="authorDB" class="com.alb.da.AuthorDB" scope="page"/>
                                <c:forEach items="${authorDB.allAuthors}" var="a">
                                    <option value="${a.id}">${a.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Publisher</td>
                        <td>
                            <select name="publisherId">
                                <jsp:useBean id="publisherDb" class="com.alb.da.PublisherDB" scope="page"/>
                                <c:forEach items="${publisherDb.allPublishers}" var="p">
                                    <option value="${p.id}">${p.name}</option>
                                </c:forEach>
                            </select>
                         </td>
                    </tr>

                    <tr>
                        <td>Status</td>
                        <td>
                            <select name="statusId">
                                <jsp:useBean id="statusDb" class="com.alb.da.StatusDB" scope="page"/>
                                <c:forEach items="${statusDb.allStatuses}" var="s">
                                    <option value="${s.id}">${s.name}</option>
                                </c:forEach>
                            </select>
                         </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" style="color: blue">Create</button>
                        </td>
                    </tr>

                </table>

            </form>
                                
        </center>
    </body>
</html>
