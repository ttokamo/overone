<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userId == null}">
    <c:redirect url="/"/>
</c:if>
<!doctype HTML>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/${userId}">Профиль</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/exchange-rates">Курсы валют <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/logout">Выход <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    </form>
  </div>
</nav>

<c:if test="${thisIsProfile == true}">
    <c:set var="user" value="${user}"/>
    Имя: ${user.getFirstName()}<br>
    Фамилия: ${user.getSecondName()}<br>
    Почта: ${user.getEmail()}<br>

    <c:if test="${user.getTelephone() != null}">
        Номер телефона: ${user.getTelephone()}<br>
    </c:if>
    <c:if test="${user.getAddress() != null}">
        Адрес: ${user.getAddress()}<br>
    </c:if>
    Дата регистрации: ${user.getCreateDate()}
</c:if>
<c:if test ="${thisIsExchangeRates == true}">
    <h2>${rates}</h2>
</c:if>
</body>

</html>