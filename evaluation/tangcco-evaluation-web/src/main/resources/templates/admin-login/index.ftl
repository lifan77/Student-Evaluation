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
    <form id="formx" class="login-form" action="/student/studentLogin" method="post">
        <select id="select" name="classId">
            <option selected="selected" value="0">请选择测评班级</option>
            <#list map?keys as key>
                <option value="${key}">${map[key]}</option>
            </#list>
        </select>
        <input id="name" name="name" type="text" placeholder="请输入真实姓名"/>
        <input id="password" name="password" type="password" placeholder="请输入密码(身份证号后六位)"/>
    </form>
        <button id="tijiao">登录</button>

</div>
<script src='/admin-login/js/jquery.min.js'></script>
<script src="/admin-login/js/index.js"></script>
<script src="/layui/layui.all.js"></script>
<script>
    $(function(){
        var msg="${msg?default('')}";
        if(msg.length!=0){
            layer.msg(msg);
        }
        $("#tijiao").click(function () {
            var select=$("#select").val();
            var name=$("#name").val();
            var password=$("#password").val();
            if(select==0||name.length==0||password==0){
                alert("请完善登录信息！")
            }else{
                $("#formx").submit();
            }
        })

        //$("#tijiao").submit()
    })
</script>
</body>

</html>
