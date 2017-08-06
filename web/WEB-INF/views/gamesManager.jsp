<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 8/6/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="template/header.jsp"%>
<div class="container">
    <h1>Games Manager</h1>
    <table class="table">
        <tr>
            <th>Game</th>
            <th>Developer</th>
            <th>Genre</th>
            <th>Platform</th>
            <th>Price</th>
            <th>Description</th>
        </tr>
        <c:forEach var="games" items="${gameList}">
            <tr>
                <td>${games.name}</td>
                <td>${games.developer.name}</td>
                <td>${games.gameGenre.name}</td>
                <td>${games.price}</td>
                <td>${games.description}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="btn-group btn-group-justified">
        <a href="/cdForm" class="btn btn-primary">Add Games</a>

    </div>

    <%@include file="template/footer.jsp"%>
</div>