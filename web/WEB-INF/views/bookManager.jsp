<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1"%>--%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
    <%--<head>--%>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>

        <%--<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"--%>
              <%--rel="stylesheet">--%>
        <%--<title>Insert title here</title>--%>

    <%--</head>--%>

    <%--<body>--%>
        <%@include file="template/header.jsp"%>
<a href="<c:url value="/logout" />">Logout</a>


        <div class="container">

            <table class="table">

                <tr>
                    <th>BookName</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th>Publisher</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>In Stock?</th>
                </tr>
                <c:forEach var="books" items="${booksList}">

                    <c:url var="updateLink" value="updateForm">
                        <c:param name="bookId" value="${books.id}" />
                    </c:url>


                    <tr>
                        <td>${books.name}</td>
                        <td>${books.author.name}</td>
                        <td>${books.genre.name}</td>
                        <td>${books.publisher.name}</td>
                        <td>${books.price}</td>
                        <td>${books.description}</td>
                        <td>${books.active}</td>
                        <td><a href="${updateLink}">Update</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <!-- <td><button type="button" class="btn btn-primary"
                            value="Add Book"
                            onclick="window.location.href='bookForm'; return false;">Add
                            Book</button></td>
                            <td><button type="button" class="btn btn-primary"
                            value="Add Book"
                            onclick="window.location.href='authorForm'; return false;">Add
                            Author</button></td> -->

                </tr>
                <tr>

                </tr>

                <div class="container">

                    <div class="btn-group btn-group-justified">

                        <a href="addUser" class="btn btn-info">User Registration</a> <a
                            href="getRole" class="btn btn-info">Manage Roles</a> <a
                            href="list" class="btn btn-info">Book Manager</a>

                    </div>
                    <h2>Book Manager</h2>
                </div>
            </table>
            <div class="btn-group btn-group-justified">
                <a href="bookForm" class="btn btn-primary">Add Book</a> <a
                    href="authorForm" class="btn btn-primary">Add Author</a>

            </div>
        <%--</div>--%>
        <hr>



<%@include file="template/footer.jsp"%>
        <%--<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
        <%--<script src="webjars/jquery/2.1.4/jquery.min.js"></script>--%>
    <%--</body>--%>

<%--</html>--%>