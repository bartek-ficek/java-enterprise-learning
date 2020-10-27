<html>
<body>
<h1>Add user from add-user.html</h1>
<% String name = (String)request.getAttribute("name"); %>
<h2>Czesc ziomeczki, nazywam sie <%=name%></h2>
<form method="post" action="/user">
    ID: <input type="text" name="id"/><br/><br/>
    Name: <input type="text" name="name"/><br/><br/>
    Login: <input type="text" name="login"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    Age: <input type="text" name="age"/><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>
</body>
</html>