<%@include file="../registeredUser/header.jsp"%>

<fieldset>
    <legend>User Account</legend>
    <div class="container">
        <table class="table table-striped table-hover" style="width:100%" id="myTable">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>session id</th>
            </tr>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td> <%= session.getId() %></td>
            </tr>


        </table>

    </div>
    <legend>Order History</legend>
    <table class="table table-striped table-hover" style="width:100%" id="myTable1">
        <thead>
            <tr class="bg-success">
                <th>Cover</th>
                <th>Item</th>
                <th>Category</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <c:forEach var="items" items="${itemsH}">
            <tr>
                    <%--<td><div class="col-md-6">--%>
                    <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                    <%--</div></td>--%>
                <td><img src="<c:url value="/resources/images/${items.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                <td>${items.name}</td>
                <td>${items.category.name}</td>
                <td>${items.price}</td>
            </tr>
        </c:forEach>

    </table>
</fieldset>

<%@include file="../registeredUser/footer.jsp"%>