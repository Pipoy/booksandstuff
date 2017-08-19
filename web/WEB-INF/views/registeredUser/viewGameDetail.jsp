
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../registeredUser/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <h1>Game info</h1>

    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${games.id}.png"/>" alt="image" style="width:100%; "/>
            </div>
            <div class="col-md-5">
                <h3>${games.name}</h3>

                <p><strong>Genre</strong> : ${games.gameGenreName}</p>
                <p><strong>Category</strong> : ${games.categoryName}</p>
                <p><strong>Developer</strong> : ${games.developerName}</p>
                <p><strong>Description</strong> : ${games.description}</p>

                <h4><strong>Price</strong> : ${games.price} USD</h4>
                <a class="btn btn-default" href="<c:url value="/auth/items/games"/>">Back</a>
                <%--<button type="button" class="btn btn-warning">Add to Cart</button>--%>
                <a class="btn btn-warning" href="<c:url value="/auth/cart/${games.id}"/>">Add to Cart</a>
            </div>
        </div>
        <%@include file="../registeredUser/footer.jsp"%>
    </div>
</div>