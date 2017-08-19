<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../template/header.jsp"%>

<div class="container">
    <h1>Cart</h1>


    <table class="table table-striped table-hover" style="width:100%" id="myTable">
        <thead>
            <tr class="bg-success">
                <th>Item</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <c:forEach var="cartItems" items="${cartItemList}">
            <%

            %>

            <tr>
                    <%--<td><div class="col-md-6">--%>
                    <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                    <%--</div></td>--%>

                <td>${cartItems.item.name}</td>
                <td>${cartItems.item.category.name}</td>
                <td>${cartItems.item.price}</td>
                <td>${cartItems.quantity}</td>
                <td>
                    <form:form action="updateQuantity" method="get" modelAttribute="cartItem">
                        <form:input path="quantity"/>
                        <%--<button  value="save" class="btn btn-primary">Update Quantity</button>--%>
                        <%--<a class="btn btn-warning" href="<c:url value="/auth/cart/{q}"/>">Add to Cart</a>--%>

                    </form:form>

                </td>
                <td><a href="<spring:url value="/auth/cart/removeItem/${cartItems.item.id}"/> ">
                    <span style="font-size: 150%" class="glyphicon glyphicon-info-sign" ></span></a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <h4>CartId: ${cart.id}</h4>
    <h4>SessionId: <%= session.getId() %></h4>




</div><%@include file="../template/footer.jsp"%>