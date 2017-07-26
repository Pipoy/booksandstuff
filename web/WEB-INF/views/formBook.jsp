<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"
              rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <style type="text/css">
            .error123 { color:red;}


        </style>
    </head>
    <body>
        <div class="container">
            <h3>Book Form</h3>
            <fieldset>
                <form:form action="saveBook" modelAttribute="bookShow" method="post"                    >
                    <form:hidden path="id" />
                    <table class="table">
                        <tr>
                            <td>Book name:</td>
                            <td><form:input path="name" /> <form:errors path="name"
                                                                        cssClass="error123" /></td>
                            <td>
                        </tr>
                        <tr>
                            <td>Author:</td>
                                <%--<td><select name="author">--%>
                                <%--<c:forEach items="${authorsShow}" var="author">--%>
                                <%--<option value="${author.id}"><c:out value="${author.name}" /></option>--%>
                                <%--</c:forEach>--%>
                                <%--</select></td>--%>
                            <td><form:select path="author" items="${authorsShow}"/></td>

                        </tr>
                        <tr>
                            <td>Genre:</td>
                            <td>
                                <div>
                                    <form:select path="genre" items="${genresShow}"/>
                                        <%--<form:select class="form-control" path="genre">--%>
                                        <%--<form:option value="NONE" label="--- Select ---"/>--%>
                                        <%--<form:options items="${genresShow}" />--%>

                                        <%--</form:select>--%>
                                </div>
                            </td>
                                <%--<li value="${test}">${test}</li>--%>



                        </tr>
                        <tr>
                            <td>Category</td>

                            <td>
                                <div>
                                    <form:select path="category" items="${categoriesShow}"/>

                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Publisher:</td>
                            <td><form:select path="publisher" items="${publishersShow}" /></td>
                        </tr>
                        <tr>
                            <td>Price:</td>
                            <td><form:input path="price" /></td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td><form:input path="description" /></td>
                        </tr>
                        <tr>
                            <td>ISBN</td>
                            <td><form:input path="isbn" /></td>
                        </tr>
                        <tr>
                            <td>active</td>
                                <%-- <td><form:input path="active" /></td> --%>
                            <td><form:radiobutton path="active" value="YES" />YES <form:radiobutton
                                    path="active" value="NO" />NO</td>
                        </tr>
                    </table>

                    <button type="submit" value="save" class="btn btn-primary">Save
                        Book</button>
                </form:form>
            </fieldset>

        </div>

    </body>
</html>