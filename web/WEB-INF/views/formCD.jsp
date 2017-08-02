<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pipoy
  Date: 8/1/2017
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="template/header.jsp"%>
<div class="container">
    <fieldset>
        <form:form action="saveCD" modelAttribute="cds" method="post" enctype="multipart/form-data">
            <form:hidden path="id"/>
            <table class="table">
                <tr>
                    <td>CD name:</td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td><form:select path="category" items="${category}"/></td>
                </tr>
                <tr>
                    <td>Artist</td>
                    <td><form:select path="artist" items="${artists}"/></td>
                </tr>
                <tr>
                    <td>Producer</td>
                    <td><form:select path="producer" items="${producers}"/></td>
                </tr>
                <tr>
                    <td>Music Genre</td>
                    <td><form:select path="musicGenre" items="${musicGenre}"/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input path="price"/></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td>active</td>
                        <%-- <td><form:input path="active" /></td> --%>
                    <td><form:radiobutton path="active" value="YES" />YES <form:radiobutton
                            path="active" value="NO" />NO</td>
                </tr>

            </table>
            <div class="form-group">
                <label class="control-label" for="productImage">Upload Image</label>
                <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
            </div>

            <button  value="save" class="btn btn-primary">Save CD</button>

        </form:form>

    </fieldset>

    <%@include file="template/footer.jsp"%>
</div>



