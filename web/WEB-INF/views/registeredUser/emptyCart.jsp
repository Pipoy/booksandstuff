<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container">
    <h1>Empty Cart</h1>


    <table class="table table-striped table-hover" style="width:100%" id="myTable">
        <thead>
            <tr class="bg-success">
                <th>Item</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>

    </table>
    <div>
        <h3>Total Price: 0</h3>
    </div>
    <%--<h4>CartId: ${cart.id}</h4>--%>
    <%--<h4>SessionId: <%= session.getId() %></h4>--%>




</div><%@include file="../registeredUser/footer.jsp"%>