<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container">
    <h1>Order Form</h1>
    <fieldset>
        <form:form modelAttribute="orderForm">
            <table class="table">
                <tr>
                    <td>City</td>
                    <td><form:input path="city"/></td>
                </tr>
                <tr>
                    <td>Street</td>
                    <td><form:input path="street"/></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><form:input path="state"/></td>
                </tr>
            </table>
        </form:form>
    </fieldset>

    <a class="btn btn-warning" href="/auth/cart/creditCardForm">Next: Payment </a>
    <h3>Total Price: $${cart.grandTotal} </h3>


</div>
<%@include file="../registeredUser/footer.jsp"%>