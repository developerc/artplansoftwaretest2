<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>your pet</title>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<script>
    var service = 'http://localhost:8080/';
    var arrData=[];

    var GetAllPets = function () {
        // var d = new Date();
        $.ajax({
            type: 'GET',
            url: service + 'pet/all',
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                arrData = JSON.parse(stringData);
                output+= '<table class="table-row-cell" border="1">';
                output+= '<tr>';
                output+= '<th>id</'+'th>';
                output+= '<th>name</'+'th>';
                output+= '<th>gender</'+'th>';
                output+= '<th>birthDay</'+'th>';
                output+= '</' +'tr>';
                for (i in arrData) {
                    output += '<tr>';
                    output += '<th>' + arrData[i].id + '</' + 'th>';
                    output += '<th>' + arrData[i].name + '</' + 'th>';
                    if (arrData[i].gender == true){
                        output += '<th>' + 'м' + '</' + 'th>';
                    } else {
                        output += '<th>' + 'ж' + '</' + 'th>';
                    }
                    // output += '<th>' + arrData[i].gender + '</' + 'th>';
                    if (arrData[i].birthDay !== null) {
                        var d = new Date(arrData[i].birthDay);
                        // d = arrData[i].birthDay;
                        output += '<th>' + d.toLocaleDateString() + '</' + 'th>';
                    } else {
                        output += '<th>' + arrData[i].birthDay + '</' + 'th>';
                    }
                    // output += '<th>' + arrData[i].birthDay + '</' + 'th>';
                    output += '</' + 'tr>';
                }

                output+= '</' +'table>';
                $('#tablePet').html(output);
                $('#errLabel').text('');
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var CheckAndAddPet = function () {
        $.ajax({
            type: 'GET',
            url: service + 'pet/getbyname/' + $("#name").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                arrData = JSON.parse(stringData);
                if (arrData.length > 0){
                    console.log('такое имя уже есть');
                    $('#errLabel').text('Такое имя уже есть!');
                    $('#errLabel').css("color", "red");
                } else {
                    AddPet();
                }
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var AddPet = function () {
        var genderPet = false;
        if ($("#gender").val() == 'м'){
            genderPet = true;
        } else {
            genderPet = false;
        }
        var JSONObject = {
            'name': $("#name").val(),
            'gender': genderPet,
            'birthDay': $("#birthDay").val()
        };
        $.ajax({
            type: 'POST',
            url: service + "pet/add",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                GetAllPets();
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        })
    };

    var GetByName = function () {
        $.ajax({
            type: 'GET',
            url: service + 'pet/getbyname/' + $("#name").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                arrData = JSON.parse(stringData);
                if (arrData.length == 0){
                    $('#errLabel').text('Такого имени нет!');
                    $('#errLabel').css("color", "red");
                    output+= '<table class="table-row-cell" border="1">';
                    output+= '<tr>';
                    output+= '<th>id</'+'th>';
                    output+= '<th>name</'+'th>';
                    output+= '<th>gender</'+'th>';
                    output+= '<th>birthDay</'+'th>';
                    output+= '</' +'tr>';
                    output+= '</' +'table>';
                    $('#tablePet').html(output);
                } else {
                    output+= '<table class="table-row-cell" border="1">';
                    output+= '<tr>';
                    output+= '<th>id</'+'th>';
                    output+= '<th>name</'+'th>';
                    output+= '<th>gender</'+'th>';
                    output+= '<th>birthDay</'+'th>';
                    output+= '</' +'tr>';
                    for (i in arrData) {
                        output += '<tr>';
                        output += '<th>' + arrData[i].id + '</' + 'th>';
                        output += '<th>' + arrData[i].name + '</' + 'th>';
                        if (arrData[i].gender == true){
                            output += '<th>' + 'м' + '</' + 'th>';
                        } else {
                            output += '<th>' + 'ж' + '</' + 'th>';
                        }
                        if (arrData[i].birthDay !== null) {
                            var d = new Date(arrData[i].birthDay);
                            output += '<th>' + d.toLocaleDateString() + '</' + 'th>';
                        } else {
                            output += '<th>' + arrData[i].birthDay + '</' + 'th>';
                        }
                        output += '</' + 'tr>';
                    }

                    output+= '</' +'table>';
                    $('#tablePet').html(output);
                    $('#errLabel').text('');
                }
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var UpdatePet = function () {
        $.ajax({
            type: 'GET',
            url: service + 'pet/getbyname/' + $("#name").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                arrData = JSON.parse(stringData);
                if (arrData.length == 0){
                    $('#errLabel').text('Такого имени нет!');
                    $('#errLabel').css("color", "red");
                    output+= '<table class="table-row-cell" border="1">';
                    output+= '<tr>';
                    output+= '<th>id</'+'th>';
                    output+= '<th>name</'+'th>';
                    output+= '<th>gender</'+'th>';
                    output+= '<th>birthDay</'+'th>';
                    output+= '</' +'tr>';
                    output+= '</' +'table>';
                    $('#tablePet').html(output);
                } else {
                    console.log('id=' + arrData[0].id + ', name=' + $("#name").val() + ', gender=' + $("#gender").val() + ', birthDay=' + $("#birthDay").val());
                   UpdPetById();
                }
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var UpdPetById = function () {
        var genderPet = false;
        if ($("#gender").val() == 'м'){
            genderPet = true;
        } else {
            genderPet = false;
        }
        var JSONObject = {
            'id':arrData[0].id,
            'name': $("#name").val(),
            'gender': genderPet,
            'birthDay': $("#birthDay").val()
        };
        $.ajax({
            type: 'PUT',
            url: service + "pet/upd",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                GetByName();
                $('#errLabel').text('Питомец успешно обновлен');
                $('#errLabel').css("color", "green");
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var DeleteByName = function () {
        $.ajax({
            type: 'GET',
            url: service + 'pet/getbyname/' + $("#name").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                arrData = JSON.parse(stringData);
                if (arrData.length > 0) {
                    DelPetById();
                } else {
                    GetAllPets();
                    $('#errLabel').text('Такой питомец в списке не значится');
                    $('#errLabel').css("color", "red");
                }
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var DelPetById = function () {
        $.ajax({
            type: 'DELETE',
            url: service + 'pet/delete/' + arrData[0].id,
            dataType: 'json',
            async: false,
            success: function (result) {
                    GetAllPets();
                    $('#errLabel').text('Питомец успешно удален');
                    $('#errLabel').css("color", "green");
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var GetPetById = function () {
        var objData = {};
        $.ajax({
            type: 'GET',
            url: service + 'pet/get/' + $("#idPet").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                var output = '';
                var stringData = JSON.stringify(result);
                objData = JSON.parse(stringData);
                output+= '<table class="table-row-cell" border="1">';

                output+= '<tr>';
                output+= '<th>id</'+'th>';
                output+= '<th>name</'+'th>';
                output+= '<th>gender</'+'th>';
                output+= '<th>birthDay</'+'th>';
                output+= '</' +'tr>';

                output += '<tr>';
                output += '<th>' + objData.id + '</' + 'th>';
                output += '<th>' + objData.name + '</' + 'th>';
                if (objData.gender == true){
                    output += '<th>' + 'м' + '</' + 'th>';
                } else {
                    output += '<th>' + 'ж' + '</' + 'th>';
                }
                if (objData.birthDay !== null) {
                    var d = new Date(objData.birthDay);
                    output += '<th>' + d.toLocaleDateString() + '</' + 'th>';
                } else {
                    output += '<th>' + objData.birthDay + '</' + 'th>';
                }
                output += '</' + 'tr>';

                output+= '</' +'table>';
                $('#tablePet').html(output);
                $('#errLabel').text('');
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };

    var DeleteById = function () {
        $.ajax({
            type: 'DELETE',
            url: service + 'pet/delete/' + $("#idPet").val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                GetAllPets();
                $('#errLabel').text('Питомец успешно удален');
                $('#errLabel').css("color", "green");
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#tablePet').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>Страница учета Ваших домашних питомцев</strong>
    </div>
    <div class="panel-body">
        <form class="form-inline">
            <label>имя:</label>
            <input id="name" value="name"/>
            <label>пол:</label>
            <input id="gender" value="м/ж"/>
            <label>день рождения:</label>
            <input id="birthDay" value="ГГГГ-ММ-ДД"/>
        </form>
        <form class="form-inline">
            <button type="button" onclick="CheckAndAddPet()">Добавить питомца</button>
            <button type="button" onclick="GetByName()">Искать по имени</button>
            <button type="button" onclick="UpdatePet()">Редактировать питомца</button>
            <button type="button" onclick="DeleteByName()">Удалить по имени</button>
            <button type="button" onclick="GetAllPets()">Показать всех</button>
        </form>
        <form class="form-inline">
            <label>ID:</label>
            <input id="idPet" value="ID"/>
            <button type="button" onclick="GetPetById()">Искать по ID</button>
            <button type="button" onclick="DeleteById()">Удалить по ID</button>
        </form>
    </div>
    <label id="errLabel"></label>
    <div class="panel-body" id="tablePet"></div>
</div>
</body>
</html>
