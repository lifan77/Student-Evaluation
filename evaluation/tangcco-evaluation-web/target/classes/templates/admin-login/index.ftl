<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flat Login Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="/admin-login/css/style.css">
    <style>
        #select{
            font-family: "微软雅黑";
            border: 1px #1a1a1a solid;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="info">
        <h1>课工场教师评测系统</h1>
        <h2>(学生端)</h2>
        <!-- <span>教务 <i class="fa fa-heart"></i>Admin</span> -->
    </div>
</div>
<div class="form">
    <div class="thumbnail"><img src="/admin-login/css/hat.svg"/></div>
    <form class="login-form" action="/student/studentLogin" method="post">
        <select id="select" name="classId">
            <option selected="selected">请选择测评班级</option>
            <#list map?keys as key>
                <option value="${key}">${map[key]}</option>
            </#list>
        </select>
        <input name="name" type="text" placeholder="请输入真实姓名"/>
        <input name="password" type="password" placeholder="请输入密码(身份证号后六位)"/>
        <button>登录</button>
    </form>
</div>
<script src='/admin-login/js/jquery.min.js'></script>
<script src="/admin-login/js/index.js"></script>
</body>

</html>