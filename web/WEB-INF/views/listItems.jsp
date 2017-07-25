<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 7/25/2017
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
              rel="stylesheet">
        <title>Insert title here</title>
    </head>
    <body>

        <div class="container">

            <table class="table">

                <tr>
                    <th>ItemName</th>
                    <th>Category</th>
                    <th>Price</th>

                </tr>
                <c:forEach var="items" items="${itemList}">
                    <tr>
                        <td>${items.name}</td>
                        <td>${items.category.name}</td>
                        <td>${items.price}</td>
                    </tr>
                </c:forEach>

        </div>



        <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/2.1.4/jquery.min.js"></script>

        
    </body>
</html>
