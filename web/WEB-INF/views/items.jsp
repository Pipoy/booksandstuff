<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All products</h1>
            <p class="lead">Check out hte products now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>(img placholder)</th>
                    <th>ItemName</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="items" items="${itemList}">
                <tr>
                        <%--<td><div class="col-md-6">--%>
                        <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                        <%--</div></td>--%>
                    <td><img src="<c:url value="/resources/images/${items.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                    <td>${items.name}</td>
                    <td>${items.category.name}</td>
                    <td>${items.price}</td>
                    <td><a href="<spring:url value="/items/viewProduct/${items.id}"/> "><span class="glyphicon glyphicon-info-sign"></span></a> </td>
                </tr>
            </c:forEach>


        </table>


<%@include file="template/footer.jsp"%>