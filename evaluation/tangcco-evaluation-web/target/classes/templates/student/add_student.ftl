<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">学员管理 / 新增学员</div>
        <div class="title">新增学员</div>
    </header>
    <footer>
        <div>
            <form action="/student/addUsers" method="post" onsubmit="return addClass()">
            <table class="biaodan" style="border-collapse:separate; border-spacing:0px 50px;" >
                <tr>
                    <td style="width: 300px;">*学生姓名:</td>
                    <td>
                        <input type="hidden" value="${classId}" name="cid">
                        <input class="layui-input x-input" type="text" id="stuName" name="stuName">
                    </td>
                </tr>
                <tr>
                    <td>*身份证号:</td>
                    <td><input class="layui-input x-input" type="text" id="number" name="number"></td>
                </tr>
                <tr>
                    <td>*登录权限:</td>
                    <td>
                        <label><input  name="login" type="radio" value="0" />无 </label>
                        <label><input  name="login" type="radio" value="1" />有 </label>
                    </td>
                </tr>
                <tr>
                    <td> <input class="layui-btn-primary x-btn-sm" type="button" onclick="javascript:history.go(-1)" value="返回"></td>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn-primary x-btn-sm"  >新增学生</button>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </footer>
</div>
<script src="/layui/lay/modules/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/layui/layui.all.js"></script>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.min.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

    });
</script>

</body>
</html>