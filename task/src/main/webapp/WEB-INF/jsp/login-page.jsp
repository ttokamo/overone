<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userId != null}">
    <c:redirect url="/${userId}"/>
</c:if>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
</body>
    <h1>Авторизация</h1>
    ${exception}
    <form action="/finish-login" method="post">
        <input type="text" placeholder="Электронная почта" name="email" autofocus/><br>
        <input type="password" placeholder="Пароль" name="password"/><br>
        <button type="submit">Войти</button>
    </form>

    Нет аккаунта ? <a href="/registration"> Зарегистрируйтесь ! </a>
</html>