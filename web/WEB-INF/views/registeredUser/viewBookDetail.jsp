<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../registeredUser/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Info</h1>
            <p class="lead">Detailed information of the product</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.id}.png"/>" alt="image" style="width:100%; "/>
                </div>

                <div class="col-md-5">
                    <h3>${product.name}</h3>

                    <p><strong>Genre</strong> : ${genre}</p>
                    <p><strong>Category</strong> : ${category}</p>
                    <p><strong>Author</strong> : ${author}</p>
                    <p><strong>ISBN</strong> : ${product.isbn}</p>
                    <p><strong>Publisher</strong> : ${publisher}</p>
                    <p><strong>Description</strong> : ${product.description}</p>

                    <h4><strong>Price</strong> : ${product.price} USD</h4>
                    <a class="btn btn-default" href="<c:url value="/auth/items/books"/>">Back</a>
                    <a class="btn btn-warning" href="<c:url value="/auth/cart/${product.id}"/>">Add to Cart</a>
                    <%--<button class="btn btn-default" id="MyButton${product.id}">Add to WishList</button>--%>




                </div>
            </div>
        </div>
        <footer>
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>
    </div>
</div><!-- /.container -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />")<\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>


