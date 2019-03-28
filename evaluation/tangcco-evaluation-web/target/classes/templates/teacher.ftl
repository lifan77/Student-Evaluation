
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/Xq.css">
    <#--<link rel="stylesheet" type="text/css" href="css/xcConfirm.css"/>-->
</head>
<body>
<div class="overall">/
    <header>
        <div class="daohang">管理 / 班主任/教员</div>
        <div class="title">教师管理</div>
        <div class="content">
            <form method="post" action="/teacherList">
            <label class="ziti">
                *:教师姓名
                <input class="layui-input x-input" type="text" name="name">
            </label>
            <label class="ziti">
                *教师类型:
                <select style="width:200px; height:28px;font-size:13px; font-family: 黑体;border: none" name="typeId">
                    <option value="" selected>请选择</option>
                    <option value="0">帅气的教员</option>
                    <option value="1">漂亮班主任</option>
                </select>
            </label>
            <input type="submit" class="layui-btn layui-btn-primary x-btn" value="搜索"/>
            </form>
        </div>
    </header>
    <footer>
        <div>
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;">新增老师</button>
            </div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">

                <thead>
                <tr>
                    <th>姓名</th>
                    <th>职务</th>
                    <th>所带班级</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                  <#list teachers as mess>
                <tr>
                    <td>${mess.tname}</td>

                    <#if mess.type==0>
                        <td>
                            教员
                        </td>
                    </#if>
                    <#if mess.type==1>
                        <td>
                            班主任
                        </td>
                    </#if>
                    <td>
                        ${mess.cname}
                    </td>
                    <td>
                        <#--<a class="caozuo">编辑</a>-->
                        <a class="caozuo" onclick="del(this,${mess.teacherId})">删除</a>
                    </td>
                </tr>
                  </#list>
                </tbody>

            </table></div>
           <#-- <div id="page" class="fenye"></div>-->
        </div>
    </footer>
</div>
<script src="layui/layui.js"></script>
<script src="js/jquery.min.js"></script>
<#--<script src="js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>-->

<script>
    layui.use(['laypage','layer'],function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            ,count: 100
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj){
            }
        });
    });
    /*$(function(){
        $("#btn7").click(function(){
            var txt=  "自定义呀";
            var option = {
                title: "自定义",
                btn: parseInt("0011",2),
                onOk: function(){
                    console.log("确认啦");
                }
            }
            window.wxc.xcConfirm(txt, "custom", option);
        });

    });*/

    /*$("#demo").click(function(){
        var typeId=$(this).val();
        window.location.href="/teacherList?typeId"
    });*/
    function del(dom,teacherId) {
        if (confirm('确认删除吗?')) {
            $.post("delTeacher","teacherId="+teacherId, function (aaa) {
                //alert(id);
                if (aaa.data == "true") {
                    $(dom).parent().parent().remove();
                    window.location.href = "teacherList";
                    alert("删除成功!");
                } else {
                    alert("删除失败!");
                }
            }, "json");
        }
    }





</script>
</body>
</html>