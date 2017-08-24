
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>


    <legend>Order History</legend>

    <c:forEach var="order" items="${orders}">
        <table class="table table-striped table-hover" style="width:100%" >
            <thead>
                <tr class="bg-success">
                    <th>Order#${order.id}</th>
                    <th>Item</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="item" items="${orderItem}">
                <tr>
                    <td><img src="<c:url value="/resources/images/${item.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                    <td>${item.name}</td>
                    <td>${item.category.name}</td>
                    <td>${item.price}</td>
                </tr>

            </c:forEach>
        </table>
        <h3>Total Price: ${order.totalPrice}</h3>
        <hr>
    </c:forEach>

<%@include file="../registeredUser/footer.jsp"%>