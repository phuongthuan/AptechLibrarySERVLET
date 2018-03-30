<%-- 
    Document   : addnewbook
    Created on : Mar 30, 2018, 12:51:22 AM
    Author     : PHUONGTHUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
        <link rel="stylesheet" href="css/style.css" />

    </head>
    <body>
        <h1>CREATE BOOK</h1>
        
            <form action="CreateBookController" method="POST">

                <table class="mytable">

                    <tr>
                        <th>Information</th>
                        <th></th> 
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
                            <input type="text" name="description" required/>
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
                            <button type="submit" style="color: blue">Add</button>
                        </td>
                    </tr>

                </table>

            </form>
                                
        <B><a href="index.jsp" style="color: red" >Home</a></B>
    </body>
</html>
