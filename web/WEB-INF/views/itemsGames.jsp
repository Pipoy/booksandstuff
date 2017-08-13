<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>
<script src="/resources/js/sortTable.js"></script>


<div class="container-wrapper">
    <div class="container">
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
            <c:forEach var="games" items="${gameList}">
                <tr>
                        <%--<td><div class="col-md-6">--%>
                        <%--<img src="/resources/images/homebookphoto.jpg"  alt="image" style="width:50%; height: 150px"/>--%>
                        <%--</div></td>--%>
                    <td><img src="<c:url value="/resources/images/${games.id}.png"/>"  alt="image" style="width: 100px; height: 150px"/></td>
                    <td>${games.name}</td>
                    <td>${games.category.name}</td>
                    <td>${games.price}</td>
                    <td><a href="<spring:url value="/items/viewProduct/${games.id}"/> ">
                        <span style="font-size: 150%" class="glyphicon glyphicon-info-sign" ></span></a>
                            <%--<button type=button class="btn btn-default btn-lg">--%>
                            <%--<span class="glyphicon glyphicon-info-sign" aria-hidden=true></span> Star--%>
                            <%--</button>--%>


                    </td>
                </tr>
            </c:forEach>
        </table>






<%@include file="template/footer.jsp"%>