<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="/js/jquery.min.js"></script>
</head>
<body>

<div class="overall">
    <header>
        <div class="daohang">班级管理 / 班级列表</div>
        <div class="title">班级列表</div>
        <div class="content">
            <form action="/ClassList" method="get">
            <label class="ziti">
                *班级编号:
                <input class="layui-input x-input" type="text" name="className">
            </label>
            <label class="ziti">
                *班级类型:
                <select class="layui-input x-input" name="gradeId">
                    <option value="">请选择班级类型</option>
                    <#list grades as g>
                    <option value="${g.gradeId}">${g.name}</option>
                    </#list>
                </select>
                <#--<input class="layui-input x-input" type="text">-->
            </label>
            <button class="layui-btn layui-btn-primary x-btn">搜索</button>
            </form>
        </div>
    </header>
    <footer>
        <div>
            <#--<div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;">新增法规</button>
            </div>-->
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>

                <tr>
                    <th>序号</th>
                    <th>班级类型</th>
                    <th>班级编号</th>
                    <th>教员</th>
                    <th>班主任</th>
                    <th>班级总人数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="body">
                <#list classes.data as class>
                <tr>
                    <td>${class.classId}</td>
                    <td>${class.grade.name}</td>
                    <td>${class.name}</td>
                    <td>${class.classTeacher.name}</td>
                    <td>${class.teacher.name}</td>
                    <td>${class.totalStu}</td>
                    <td>
                        <a href="classDetail?classId=${class.classId}" class="caozuo">查看</a>
                        <a href="/student/userList?classId=${class.classId}" class="caozuo">学员</a>
                        <a href="updateClass?classId=${class.classId}" class="caozuo">编辑</a>
                        <a href="#" onclick="deleteClass(${class.classId})" class="caozuo">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page" class="fenye"></div>
        </div>
    </footer>
</div>
<script src="/layui/layui.js"></script>
<script>
    function deleteClass(classId) {
        var con=confirm("确认删除吗？");
        if (con){
            $.post("deleteClass",{classId:classId},function(status){
                if(status==true){
                    alert("删除成功")
                    window.location.href="/ClassList";
                }else{
                    alert("删除失败")
                }
            })
        }
    }
</script>
<script>
    layui.use(['laypage','layer'],function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            ,count: '${classes.total}'
            ,limit:'${classes.pageSize}'
            ,curr:'${classes.pageNo}'
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj){

                    $.ajax({
                        type:'post',
                        url:"ajaxClassList",
                        data:{pageNo:obj.curr,pageSize:obj.limit},dataType:'json',
                        success:function (result) {
                            var list = result.data;
                            if(list.length>0){
                                var html ="";
                                for(var i = 0;i<list.length;i++){
                                    html+="   <tr>\n" +
                                            "                    <td>"+list[i].classId+"</td>\n" +
                                            "                    <td>"+list[i].grade.name+"</td>\n" +
                                            "                    <td>"+list[i].name+"</td>\n" +
                                            "                    <td>"+list[i].classTeacher.name+"</td>\n" +
                                            "                    <td>"+list[i].teacher.name+"</td>\n" +
                                            "                    <td>"+list[i].totalStu+"</td>\n" +
                                            "                    <td>" +
                                            "                   <n></n><a href=\"classDetail?classId="+list[i].classId+"\" class=\"caozuo\">查看</a>\n" +
                                            "                        <a href=\"/student/userList?classId="+list[i].classId+"\" class=\"caozuo\">学员</a>\n" +
                                            "                        <a href=\"updateClass?classId="+list[i].classId+"\" class=\"caozuo\">编辑</a>\n" +
                                            "                        <a href=\"\" class=\"caozuo\">删除</a>\n" +
                                            "                    </td>\n" +
                                            "                </tr>";
                                }
                                $("#body").html(html);
                            }


                        }
                    });


            }
        });
    })

</script>
</body>
</html>