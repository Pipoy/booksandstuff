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
    <table class="table table-striped table-hover" style="width:100%" id="myTable1">
        <thead>
            <tr class="bg-success">
                <th></th>
                <th>Item</th>
                <th>Category</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <c:forEach var="items" items="${itemsH}">
            <tr>
                <td><img src="<c:url value="/resources/images/${items.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                <td><span style="font-weight: bold">${items.name}</span></td>
                <td>${items.category.name}</td>
                <td>${items.price}</td>
                <td><a href="<spring:url value="/auth/items/viewProduct/${items.id}"/> ">
                    <span style="font-size: 150%" class="glyphicon glyphicon-info-sign" ></span></a>

                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
<%@include file="../registeredUser/footer.jsp"%>