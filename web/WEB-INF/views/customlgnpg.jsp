<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Custom Login page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>главная страница входа в приложение</h2>
    <form name="f" action='/login' method='POST'>
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="login" class="form-control" id="login" placeholder="Введите логин" name="login">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <input name="submit" type="submit" value="Login"/>
        <%--<button type="submit"  class="btn btn-default">Submit</button>--%>
        <%-- <button type="submit" onclick="location.href='http://localhost:8080/setaccount'" >Создать Аккаунт</button>--%>
        <a href="/setaccount" class="btn btn-default" role="button">Создать аккаунт</a>
    </form>
</div>

</body>
</html>
