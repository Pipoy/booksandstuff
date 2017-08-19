<%@include file="../registeredUser/header.jsp"%>

<fieldset>
    <legend>User Account</legend>
    <div class="container">
        <table class="table table-striped table-hover" style="width:100%" id="myTable">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>session id</th>
            </tr>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td> <%= session.getId() %></td>
            </tr>


        </table>

    </div>
    <legend>Order History</legend>
</fieldset>

<%@include file="../registeredUser/footer.jsp"%>