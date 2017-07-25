<%@ page language="java" contentType="text/html;
charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Form</title>


    </head>
    <body>
        <fieldset>
            <legend>User Input From</legend>
            <form:form action="login" method="post" modelAttribute="user">
                <table>
                    <tr>
                        <td>Email</td>
                        <td>
                            <form:input path="email" />
                            <form:errors path="email" cssClass="error" />
                        </td>
                    </tr><tr>
                    <tr>
                        <td>password</td>
                        <td>
                            <form:input path="password" />
                        </td>
                    </tr>

                    <td><button type="submit">Submit</button></td></td>
                    </tr>
                </table>
            </form:form>
        </fieldset>
        <br>
        <br>

    </body>
</html>