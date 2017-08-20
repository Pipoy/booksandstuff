
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container">
    <h1>Order Summary</h1>
    <table class="table table-striped table-hover" style="width:100%" id="myTable">
        <thead>
            <tr class="bg-success">
                <th></th>
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

                <td><img src="<c:url value="/resources/images/${cartItems.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                <td>${cartItems.item.name}</td>
                <td>${cartItems.item.category.name}</td>
                <td>${cartItems.item.price}</td>
                    <%--<td>${cartItems.quantity}</td>--%>


            </tr>

        </c:forEach>




    </table>



    <h3>Total Price: $${cart.grandTotal} </h3>
    <a class="btn btn-warning" href="/auth/cart/finish">Return</a>


</div>
<%@include file="../registeredUser/footer.jsp"%>