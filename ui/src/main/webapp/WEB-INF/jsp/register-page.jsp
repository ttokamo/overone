<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
</body>
    <h1>Регистрация</h1>
    <form action="/ui/finish-registration.do" method="post">
        <input type="text" placeholder="Имя" name="firstName" focusinput/><br>
        <input type="text" placeholder="Фамилия" name="secondName"/><br>
        <input type="text" placeholder="Электронная почта" name="email"/><br>
        <input type="text" placeholder="Адрес" name="address"/><br>
        <input type="password" placeholder="Пароль" name="password"/><br>
        <button type="submit">Регистрация</button>
    </form>
</html>