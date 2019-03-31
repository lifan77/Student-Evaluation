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
        <div class="daohang">班级管理 / 修改班级</div>
        <div class="title">修改班级</div>
    </header>
    <footer>
        <div>
            <#--onsubmit="return updateClass()-->
            <form action="/student/updateStus" method="post">
            <input type="hidden" id="stuId" name="stuId" value="${user.userId}" />
            <table class="biaodan" style="border-collapse:separate; border-spacing:0px 50px;" >
                <tr>
                    <#--<td><input type="hidden" value="${user.userId}" name="stuId"></td>-->
                    <td><input type="hidden" value="${user.password}" name="stuPwd"></td>
                </tr>
                <tr>
                    <td style="width: 300px;">*学员姓名:</td>
                    <td><input class="layui-input x-input" value="${user.name}" type="text" id="stuName" name="stuName"></td>
                </tr>
                <tr>
                    <td>*选择班级:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="stuClassId" id="stuClassId">
                            <#list classes as class>
                                    <option value="${class.classId}"
                                        <#if user.classId==class.classId>
                                            selected
                                        </#if>
                                    >${class.name}</option>
                            </#list>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*省份证号:</td>
                    <td><input class="layui-input x-input" value="${user.number}" type="text" id="stuNum" name="stuNum"></td>
                </tr>
                <tr>
                    <td>*登录权限:</td>
                    <td>
                        <label><input  name="login" type="radio" value="0"
                            <#if user.land=0>
                                checked
                            </#if>
                        />无 </label>
                        <label><input  name="login" type="radio" value="1"
                            <#if user.land=1>
                                checked
                            </#if>
                        />有 </label>
                    </td>
                </tr>

                <tr>
                    <td> <input class="layui-btn-primary x-btn-sm" type="button" onclick="javascript:history.go(-1)" value="返回"></td>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn-primary x-btn-sm" >修改班级</button>
                        <input type="submit" class="layui-btn-primary x-btn-sm" value="修改" />
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
<script>
    function addClass(){
        var className=document.getElementById("className").value;
        if(className==""){
            alert("班级名称不能为空！");
            return false;
        }
        var classTypeId=document.getElementById("classType").value;
        if(classTypeId==""){
            alert("请选择班级类型！");
            return false;
        }
        var teacherId=document.getElementById("teacherId").value;
        if(teacherId==""){
            alert("请选择该班班主任！");
            return false;
        }
        var classTeacherId=document.getElementById("classTeacherId").value;
        if(classTeacherId==""){
            alert("请选择该班教员！");
            return false;
        }
        var classNum=document.getElementById("classNum").value;
        if(classNum==""){
            alert("班级总人数不能为空！");
            return false;
        }
        var classDate=document.getElementById("classDate").value;
        if(classDate==""){
            alert("开班时间不能为空！");
            return false;
        }
      /*  var classJson = {
            "name" :className,
            "teacherId" :teacherId,
            "classTeacherId":classTeacherId,
            "gradeId":classTypeId,
            "totalStu":classNum,
            "openTime": classDate
        }
        $.ajax({
            type : "POST",
            url:
        })*/
    }
</script>
</body>
</html>