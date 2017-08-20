<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container">
    <h1>Order Form</h1>

    <a class="btn btn-warning" href="/auth/cart/orderSummary">Place Order</a>
    <h3>Total Price: $${cart.grandTotal} </h3>


</div>
<%@include file="../registeredUser/footer.jsp"%>