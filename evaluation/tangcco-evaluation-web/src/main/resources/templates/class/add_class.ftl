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
        <div class="daohang">班级管理 / 新增班级</div>
        <div class="title">新增班级</div>
    </header>
    <footer>
        <div>
            <form action="/addClasses" method="post" onsubmit="return addClass()">
            <table class="biaodan" style="border-collapse:separate; border-spacing:0px 50px;" >
                <tr>
                    <td style="width: 300px;">*班级名称:</td>
                    <td><input class="layui-input x-input" type="text" id="className" name="className"></td>
                </tr>
                <tr>
                    <td>*选择所属班型:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="classType" id="classType">
                                <option value="请选择">请选择</option>
                                <#list grades as grade>
                                 <option value="${grade.gradeId}">${grade.name}</option>
                                </#list>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*选择班主任:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="teacherId" id="teacherId">
                                <option value="请选择">请选择</option>
                                <#list teacher as teac>
                                <option value="${teac.teacherId}">${teac.name}</option>
                                </#list>
                            </select>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>*选择教员:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="classTeacherId" id="classTeacherId">
                                <option value="请选择">请选择</option>
                                <#list classTeacher as cteac>
                                <option value="${cteac.teacherId}">${cteac.name}</option>
                                </#list>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*班级人数:</td>
                    <td><input class="layui-input x-input" type="text" id="classNum" name="classNum"></td>
                </tr>
                <tr>
                    <td>*开班时间:</td>
                    <td><input class="layui-input x-input" type="date" id="classDate" name="classDate"></td>
                </tr>
                <tr>
                    <td> <input class="layui-btn-primary x-btn-sm" type="button" onclick="javascript:history.go(-1)" value="返回"></td>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn-primary x-btn-sm"  >新增班级</button>
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