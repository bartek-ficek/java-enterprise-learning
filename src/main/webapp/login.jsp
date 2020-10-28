<%--
  Created by IntelliJ IDEA.
  User: bartek
  Date: 28.10.2020
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Servlet</title>
</head>
<body>
<form method="post" action="/login">
    Login: <input type="text" name="login"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    <input type="submit" name="signing" value="Sign In"/><br/><br/>
</form>

</body>
</html>
