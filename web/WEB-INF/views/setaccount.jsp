<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Set account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Страница добавления аккаунта</h2>
    <form >
        <div class="form-group">
            <label for="username">Login:</label>
            <input type="username" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="password2">Reenter password:</label>
            <input type="password" class="form-control" id="password2" placeholder="Reenter password" name="password2">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <button type="button" onclick="AddLgnPsw()" class="btn btn-default">Submit</button>
    </form>
</div>
<script>

    var AddLgnPsw = function () {
        var lgn = '';
        var pwd1 = '';
        var pwd2 = '';
        lgn = $("#username").val();
        pwd1 = $("#password").val();
        pwd2 = $("#password2").val();

      console.log('AddLgnPsw, ' + 'lgn=' + lgn + ', pwd1=' + pwd1 + ', pwd2=' + pwd2);
      if (pwd1 == pwd2){
          console.log('validation cuccesful');
      } else {
          console.log('validation not cuccesful');
      }
    };

</script>

</body>
</html>

