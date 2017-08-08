<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 8/1/2017
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="template/header.jsp"%>

<div class="container">
    <table class="table">
        <tr>
            <th>BookName</th>
            <th>Artist</th>
            <th>Genre</th>
            <th>Producer</th>
            <th>Price</th>
            <th>Description</th>
            <th>In Stock?</th>
        </tr>
        <c:forEach var="cds" items="${cdList}">
            <c:url var="updateLink" value="/admin/cdManager/updateFormCD">
                <c:param name="cdId" value="${cds.id}"/>
            </c:url>
            <tr>
                <td>${cds.name}</td>
                <td>${cds.artist.name}</td>
                <td>${cds.musicGenre.name}</td>
                <td>${cds.producer.name}</td>
                <td>${cds.price}</td>
                <td>${cds.description}</td>
                <td>${cds.active}</td>
                <td><a href="${updateLink}">Update</a></td>
            </tr>
        </c:forEach>

    </table>
    <div class="btn-group btn-group-justified">
        <a href="<c:url value="/admin/cdManager/cdForm"/>" class="btn btn-primary">Add CD</a>

    </div>
    <%@include file="template/footer.jsp"%>
</div>

