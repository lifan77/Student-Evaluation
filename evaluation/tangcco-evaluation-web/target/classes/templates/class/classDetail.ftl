<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/Xq.css">
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">班级管理 / 班级详情</div>
        <div class="title">班级详情</div>
    </header>
    <footer>
        <div>
            <table class="biaodan" style="border-collapse:separate; border-spacing:0px 50px;" >
                <tr>
                    <td style="width: 300px;">*班级id:</td>
                    <td><input class="layui-input x-input" value="${class.classId}" type="text" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*班级名称:</td>
                    <td><input class="layui-input x-input" value="${class.name}" type="text" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*教员:</td>
                    <td><input class="layui-input x-input" value="${class.classTeacher.name}" type="text" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*班主任:</td>
                    <td><input class="layui-input x-input" value="${class.teacher.name}" type="text" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*所属班型:</td>
                    <td><input class="layui-input x-input" value="${class.grade.name}" type="text" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*班级状态:</td>
                    <td>
                        <#if (class.status)?? && class.status=0>
                            <input class="layui-input x-input" value="存在" type="text" id="className" readonly="true">
                        <#elseif (class.status)??  && class.status=1>
                            <input class="layui-input x-input" value="不存在" type="text" id="className" readonly="true">
                        </#if>
                     </td>
                </tr>
                <tr>
                    <td style="width: 300px;">*班级总人数:</td>
                    <td><input class="layui-input x-input" type="text" value="${class.totalStu}" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*开班时间:</td>
                    <td><input class="layui-input x-input"  type="text" value="${class.openTime?string('yyyy-MM-dd')}" id="className" readonly="true"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn-primary x-btn-sm" onclick="javascript:history.go(-1)" >返回</button>
                    </td>
                </tr>
            </table>
        </div>
    </footer>
</div>
<script src="layui/lay/modules/jquery-3.3.1.min.js"></script>
<script src="layui/layui.js"></script>
<script src="layui/layui.all.js"></script>
<script src="layui/layui.js"></script>
<script src="js/jquery.min.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

    });
</script>

</body>
</html>