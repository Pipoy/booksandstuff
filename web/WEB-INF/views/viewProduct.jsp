<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Info</h1>
            <p class="lead">Detailed information of the product</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="/resources/images/bookphoto.jpg" alt="image" style="width:100%; height: 300px"/>
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

                </div>
            </div>
        </div>




<%@include file="template/footer.jsp"%>