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
        <div class="daohang">测评管理 / 测评列表</div>
        <div class="title">测评列表</div>
        <div class="content">
            <form action="/paper/papers" method="post" id="relation">
            <label class="ziti">
                创建时间:
                <input name="date1" value="${date1}" class="layui-input x-input" type="date">至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="date2" value="${date2}" class="layui-input x-input" type="date">
            </label>
                <input class="layui-btn layui-btn-primary x-btn" value="搜索" type="submit"/>
            </form>

        </div>
    </header>
    <footer>
        <div>
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;" onclick="location.href='/paper/savePage'">新增评测</button>
            </div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>创建时间</th>
                    <th>标题</th>
                    <th>说明</th>
                    <th>评测班级</th>
                    <th>评测人员</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>题目</th>
                </tr>
                </thead>
                <tbody>
                    <#list papers as paper>
                    <tr>
                        <td>${paper.createTime?datetime}</td>
                        <td>${paper.title}</td>
                        <td>${paper.direction}</td>
                        <td>
                            <#assign classes=paper.classes?eval />
                            <#list classes.classes as class>
                                ${class.name}
                            </#list>
                        </td>
                        <td>${(paper.teacherType==0)?string('教员','班主任')}</td>
                        <td>${paper.beginTime?datetime}</td>
                        <td>${paper.endTime?datetime}</td>
                        <td><input type="button" value="查看" onclick="location.href='/question/questions?gradeId=${classes.gradeId}&teacherType=${paper.teacherType} '" class="layui-btn layui-btn-sm"/></td>
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
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            , count: ${total}
            , limit:${size}
            , curr:${page}
            , layout: ['count', 'prev', 'page', 'next','first','last']
            , jump: function (obj,first) {
                if(!first){
                    var url="/paper/papers?page="+obj.curr;
                    $("#relation").attr("action",url);
                    $("#relation").submit();
                }
            }
        });
    })

</script>
</body>
</html>