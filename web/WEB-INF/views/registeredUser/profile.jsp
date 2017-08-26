
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<fieldset>
    <legend>User Account</legend>
    <div class="container">
        <table class="table table-striped table-hover" style="width:100%" id="myTable">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
            </tr>
        </table>
    </div>
    <legend>Order History</legend>


    <div class="container">
        <table class="table table-striped table-hover" style="width:100%" id="myTable">


            <tr>
                <th>Order Id</th>
                <th>Date of Purchase</th>
                <th>Total Price</th>
            </tr>
            <c:forEach var="order" items="${orders}">
            <tr>
                <td><a href="<spring:url value="/auth/userProfile/${order.id}"/> ">Order # ${order.id} </a></td>
                <td>${order.dateOfPurchase}</td>
                <td>${order.totalPrice}</td>
            </tr>
            </c:forEach>
        </table>
    </div>

        <%--<h3></h3>--%>
        <%--<h5>Total Price:${order.totalPrice}</h5>--%>
        <%--<h5>Date of Purchase: ${order.dateOfPurchase}</h5>--%>

        <%--<table class="table table-striped table-hover" style="width:100%" >--%>
        <%--<thead>--%>
        <%--<tr class="bg-success">--%>
        <%--<th>Order#${order.id}</th>--%>
        <%--<th>Item</th>--%>
        <%--<th>Category</th>--%>
        <%--<th>Price</th>--%>
        <%--<th></th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<c:forEach var="item" items="${orderItem}">--%>
        <%--<tr>--%>
        <%--<td></td>--%>
        <%--<td>${item.name}</td>--%>
        <%--<td>${item.category.name}</td>--%>
        <%--<td>${item.price}</td>--%>
        <%--</tr>--%>

        <%--</c:forEach>--%>
        <%--</table>--%>
        <%--<h3>Total Price: ${order.totalPrice}</h3>--%>
    <hr>


    <%--<table class="table table-striped table-hover" style="width:100%" id="myTable1">--%>
    <%--<thead>--%>
    <%--<tr class="bg-success">--%>
    <%--<th></th>--%>
    <%--<th>Item</th>--%>
    <%--<th>Category</th>--%>
    <%--<th>Price</th>--%>
    <%--<th></th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<c:forEach var="items" items="${itemsH}">--%>
    <%--<tr>--%>
    <%--<td><img src="<c:url value="/resources/images/${items.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>--%>
    <%--<td><span style="font-weight: bold">${items.name}</span></td>--%>
    <%--<td>${items.category.name}</td>--%>
    <%--<td>${items.price}</td>--%>
    <%--<td><a href="<spring:url value="/auth/items/viewProduct/${items.id}"/> ">--%>
    <%--<span style="font-size: 150%" class="glyphicon glyphicon-info-sign" ></span></a>--%>

    <%--</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>
</fieldset>
<%@include file="../registeredUser/footer.jsp"%>