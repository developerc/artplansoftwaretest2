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
    <label id="errLabel"></label>
    <form>
        <div class="form-group">
            <label for="username">Login:</label>
            <input type="login" class="form-control" id="username" placeholder="Enter login" name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <button type="button" onclick="AuthUser()" class="btn btn-default">Login</button>
    </form>
</div>
<script>
    var service = 'http://localhost:8080/';
    // var lgn = '';
    // var pwd = '';

    var AuthUser = function () {
        $.ajax({
            type: 'POST',
            url: service + "login",
            data: jQuery.param({ username: $("#username").val(), password : $("#password").val()}) ,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            success: function (result) {
                console.log('Login user success');
                $('#errLabel').text('Проверка логина и пароля');
                $('#errLabel').css("color", "green");
                setTimeout('window.open(\'http://localhost:8080/pet\', \'_blank\')', 3000);
            },
            error: function (jqXHR, testStatus, errorThrown) {
                console.log('Failed login user');
            }
        });
    };
</script>

</body>
</html>
