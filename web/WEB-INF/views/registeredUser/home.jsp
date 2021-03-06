<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../registeredUser/header.jsp"%>
<!DOCTYPE html>
<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">

        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="/resources/images/c7.png" alt="First slide"  >
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Browse GAMES !</h1>
                            <%--<p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>--%>
                            <p><a class="btn btn-lg btn-primary" href="/auth/items/games" role="button">Browse Games</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="/resources/images/c8.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Listen and Chill</h1>
                            <%--<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>--%>
                            <p><a class="btn btn-lg btn-primary" href="/auth/items/cds" role="button">Browse Music!</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide home-image" src="/resources/images/c1.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Read a Book!</h1>
                            <p><a class="btn btn-lg btn-primary" href="/auth/items/books" role="button">Browse gallery</a></p>

                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <%--<!-- Three columns of text below the carousel -->--%>
            <%--<div class="row">--%>
                <%--<div class="col-lg-4">--%>
                    <%--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">--%>
                    <%--<h2>Heading</h2>--%>
                    <%--<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>--%>
                    <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
                <%--</div><!-- /.col-lg-4 -->--%>
                <%--<div class="col-lg-4">--%>
                    <%--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">--%>
                    <%--<h2>Heading</h2>--%>
                    <%--<p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>--%>
                    <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
                <%--</div><!-- /.col-lg-4 -->--%>
                <%--<div class="col-lg-4">--%>
                    <%--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">--%>
                    <%--<h2>Heading</h2>--%>
                    <%--<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>--%>
                    <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
                <%--</div><!-- /.col-lg-4 -->--%>
            <%--</div><!-- /.row -->--%>




            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="#">Back to top</a></p>
                <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>
