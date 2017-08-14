<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page language="java" contentType="text/html;--%>
<%--charset=ISO-8859-1"--%>
<%--pageEncoding="ISO-8859-1"%>--%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html>--%>
<%@include file="template/header.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Form</title>

        <style type="text/css">


            body {
                background: #eee !important;
            }

            .wrapper {
                margin-top: 80px;
                margin-bottom: 80px;
            }

            .form-signin {
                max-width: 380px;
                padding: 15px 35px 45px;
                margin: 0 auto;
                background-color: #fff;
                border: 1px solid rgba(0,0,0,0.1);}

            .form-signin-heading,
            .checkbox {
                margin-bottom: 30px;
            }

            .checkbox {
                font-weight: normal;
            }

            .form-control {
                position: relative;
                font-size: 16px;
                height: auto;
                padding: 10px;
            @include box-sizing(border-box);}

            &:focus {
                 z-index: 2;

            }

            input[type="text"] {
                margin-bottom: -1px;
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }

            input[type="password"] {
                margin-bottom: 20px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
            .error {
                color: red;
            }



        </style>



    </head>
    <body>
       <div class="container">

               <%--<fieldset>--%>
                   <%--<legend>User Input From</legend>--%>
                   <%--<form:form action="login" method="post" modelAttribute="user" cssClass="form-signin">--%>
                       <%--<table>--%>
                           <%--<tr>--%>
                               <%--<td>Email</td>--%>
                               <%--<td>--%>
                                   <%--<form:input path="email" cssClass="form-control"/>--%>
                                   <%--<form:errors path="email" cssClass="error" />--%>
                               <%--</td>--%>
                           <%--</tr>--%>
                           <%--<tr>--%>
                               <%--<td>Password</td>--%>
                               <%--<td>--%>
                                   <%--<form:input path="password" cssClass="form-control"/>--%>
                               <%--</td>--%>
                           <%--</tr--%>
                               <%--<tr>--%>

                           <%--<td><button type="submit" class="btn btn-lg btn-primary btn-block">Login</button></td>--%>
                           <%--</tr>--%>
                       <%--</table>--%>
                   <%--</form:form>--%>
               <%--</fieldset>--%>


                   <div class="wrapper">
                       <fieldset>
                           <form:form cssClass="form-signin"  action="login" method="post" modelAttribute="user">
                               <h2 class="form-signin-heading">Please login</h2>
                               <form:input type="text" cssClass="form-control"   name="username" placeholder="Email Address" required="" autofocus="" path="email" />
                               <form:errors path="email" cssClass="error" />
                               <form:input type="password" cssClass="form-control" name="password" placeholder="Password" required="" path="password"/>

                               <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                           </form:form>
                       </fieldset>
                   </div>


               <%@include file="template/footer.jsp"%>


       </div>
    </body>

</html>