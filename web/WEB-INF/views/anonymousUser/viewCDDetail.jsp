<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 8/1/2017
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Info</h1>
            <p class="lead">Detailed information of the product</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${cd.id}.png"/>" alt="image" style="width:100%; "/>
                </div>

                <div class="col-md-5">
                    <h3>${cd.name}</h3>

                    <p><strong>Genre</strong> : ${cd.musicGenreName}</p>
                    <p><strong>Category</strong> : ${cd.categoryName}</p>
                    <p><strong>Producer</strong> : ${cd.producerName}</p>
                    <p><strong>Description</strong> : ${cd.description}</p>

                    <h4><strong>Price</strong> : ${cd.price} USD</h4>
                    <a class="btn btn-default" href="<c:url value="/items/cds"/>">Back</a>
                    <%--<a class="btn btn-warning" href="<c:url value="/loginForm"/>">Login To Buy</a>--%>
                    <a class="btn btn-warning" href="<c:url value="/loginForm"/>">Login To Buy</a>

                </div>
            </div>
        </div>
        <%@include file="../template/footer.jsp"%>
    </div>

</div>


