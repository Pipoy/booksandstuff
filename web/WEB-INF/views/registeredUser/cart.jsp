<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container">
    <h1>Cart</h1>



    <table class="table table-striped table-hover" style="width:100%" id="myTable">
        <thead>
            <tr class="bg-success">
                <th>Item</th>
                <th>Category</th>
                <th>Price</th>
                <%--<th>Quantity</th>--%>


            </tr>
        </thead>
        <c:forEach var="cartItems" items="${cartItemList}">
            <tr>
                    <%--<td><div class="col-md-6">--%>
                    <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                    <%--</div></td>--%>

                <td>${cartItems.item.name}</td>
                <td>${cartItems.item.category.name}</td>
                <td>${cartItems.item.price}</td>
                <%--<td>${cartItems.quantity}</td>--%>

                    <%--<td>--%>
                    <%--<form:form action="updateQuantity" method="get" modelAttribute="cartItem">--%>
                    <%--<form:input path="quantity"/>--%>
                    <%--&lt;%&ndash;<button  value="save" class="btn btn-primary">Update Quantity</button>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a class="btn btn-warning" href="<c:url value="/auth/cart/{q}"/>">Add to Cart</a>&ndash;%&gt;--%>
                    <%--</form:form>--%>
                    <%--</td>--%>
                <td><a href="<spring:url value="/auth/cart/removeItem/${cartItems.item.id}"/> ">
                    <span style="font-size: 150%" class="glyphicon glyphicon-remove" ></span></a>
                </td>
                <%--<td>--%>
                    <%--<a class="btn btn-warning" href="/auth/cart/removeItem/${cartItems.item.id}">Clear Cart</a>--%>
                <%--</td>--%>

            </tr>

        </c:forEach>




    </table>
    <%--<a class="btn btn-warning" href="<c:url value="/auth/cart/emptyCart"/>">Clear Cart</a>--%>
    <a class="btn btn-warning" href="/auth/cart/orderForm">Submit</a>
    <p class="pull-right"><a class="btn btn-danger" href="/auth/cart/emptyCart">Clear Cart</a></p>
    <h3>Total Price: $${cart.grandTotal} </h3>


    <%--<h4>CartId: ${cart.id}</h4>--%>
    <%--<h4>SessionId: <%= session.getId() %></h4>--%>




</div><%@include file="../registeredUser/footer.jsp"%>