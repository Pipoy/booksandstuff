<%@include file="../registeredUser/header.jsp"%>
<div class="container">
    <h1>Admin Menu</h1>
    <hr>

    <h2><a href="<c:url value="/admin/userManager/addUser"/>">User Manager</a></h2>
    <h2><a href="<c:url value="/admin/bookManager/"/>">Book Manager</a></h2>
    <h2><a href="<c:url value="/admin/cdManager/"/>">CD Manager</a></h2>
    <h2><a href="<c:url value="/admin/gamesManager/"/>">Games Manager</a></h2>



</div>

<footer class="panel-footer">
    <%@include file="../registeredUser/footer.jsp"%>
</footer>