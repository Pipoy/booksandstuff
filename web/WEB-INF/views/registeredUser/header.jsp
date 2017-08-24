<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 7/22/2017
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Carousel Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


        <%--<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">--%>

    </head>
    <!-- NAVBAR
    ================================================== -->
    <body>
        <div class="navbar-wrapper">
            <div class="container">

                <nav class="navbar navbar-inverse navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">BooksAndStuff</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="/index">Home</a></li>
                                <li><a href="<c:url value="/auth/items"/>">All Products</a></li>
                                <%--<li><a href="#about">About</a></li>--%>
                                <%--<li><a href="#contact">Contact</a></li>--%>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value="/auth/items/books"/>">Books</a></li>
                                        <li><a href="<c:url value="/auth/items/cds"/>">CD</a></li>
                                        <li><a href="<c:url value="/auth/items/games"/>">Games</a></li>
                                    </ul>

                                </li>
                            </ul>


                            <ul class="nav navbar-nav pull-right">
                                <li><a href="/auth/logout">Logout &nbsp &nbsp</a></li>
                            </ul>
                            <ul class="nav navbar-nav pull-right">
                                <li><a href="/auth/userProfile">${sessionScope["userEmail"]} &nbsp &nbsp</a></li>
                            </ul>

                            <ul class="nav navbar-nav pull-right">
                                <li><a href="/auth/cart">Cart &nbsp &nbsp</a></li>
                            </ul>

                        </div>
                    </div>
                </nav>