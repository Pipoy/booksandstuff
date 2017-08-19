<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../template/header.jsp"%>

<script src="/resources/js/sortTable.js"></script>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All products</h1>
            <p class="lead">Check out hte products now!</p>
        </div>


        <form>
            <label>Sort By Title</label>
            <input type="radio" class="priority" name="priorityN" onclick="sortTable(1)" value="1" />
            <label>Sort by Price</label>
            <input type="radio" class="priority" name="priorityN" onclick="sortTable(3)" value="3" />
        </form>


        <table class="table table-striped table-hover" style="width:100%" id="myTable">
            <thead>
                <tr class="bg-success">
                    <th>Cover</th>
                    <th>Item</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="items" items="${itemList}">
                <tr>
                        <%--<td><div class="col-md-6">--%>
                        <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                        <%--</div></td>--%>
                    <td><img src="<c:url value="/resources/images/${items.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                    <td>${items.name}</td>
                    <td>${items.category.name}</td>
                    <td>${items.price}</td>
                    <td><a href="<spring:url value="/auth/items/viewProduct/${items.id}"/> ">
                        <span style="font-size: 150%" class="glyphicon glyphicon-info-sign" ></span></a>
                    </td>
                </tr>
            </c:forEach>

        </table>

<%@include file="../registeredUser/footer.jsp"%>