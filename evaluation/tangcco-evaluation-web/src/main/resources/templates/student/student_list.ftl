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
        <div class="daohang">学员管理 / 学员列表</div>
        <div class="title">学员列表</div>
        <div class="content">
            <form action="/ClassList" method="get">
            <label class="ziti">
                 *学员姓名:
            <input class="layui-input x-input" type="text" name="className">
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
                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>登录权限</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="body">
                <#list userList.data as user>
                <tr>
                    <td>${user.classId}</td>
                    <td>${user.name}</td>
                    <td>${user.number}</td>
                    <td>
                        <#if (user.land)?? && user.land=0>
                            否
                        <#elseif (user.land)?? && user.land=1>
                            是
                        </#if>
                    </td>
                    <td>
                        <a href="#" class="caozuo">查看</a>
                        <a href="#" class="caozuo">编辑</a>
                        <a href="#" onclick="" class="caozuo">删除</a>
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
            ,count: '${userList.total}'
            ,limit:'${userList.pageSize}'
            ,curr:'${userList.pageNo}'
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj){
                    $.ajax({
                        type:'post',
                        url:"ajaxUserList",
                        data:{pageNo:obj.curr,pageSize:obj.limit},dataType:'json',
                        success:function (result) {
                            var list = result.data;
                            if(list.length>0){
                                var html ="";
                                for(var i = 0;i<list.length;i++){
                                    html+="   <tr>\n" +
                                            "                    <td>"+list[i].classId+"</td>\n" +
                                            "                    <td>"+list[i].name+"</td>\n" +
                                            "                    <td>"+list[i].number+"</td>\n" +
                                            "                    <td>"+list[i].land+"</td>\n" +
                                            "                    <td>" +
                                            "                   <n></n><a href=\"\" class=\"caozuo\">查看</a>\n" +
                                            "                        <a href=\"\" class=\"caozuo\">编辑</a>\n" +
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