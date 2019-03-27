<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="/js/jquery.min.js"></script>
    <script>
        function del(questionId) {
            $.ajax({
                type:"post",
                url: "delete?questionId="+questionId,
                dataType: "json",
                success: function (data) {
                    if (data.flag) {
                        alert(data.message);
                        window.location.reload();
                    } else {
                        alert(data.message);
                    }
                },
                error: function () {
                    alert("系统异常");
                }
            });
        }
    </script>
</head>
<body>

<div class="overall">
    <header>
        <div class="daohang">题库管理 / 题目列表</div>
        <div class="title">题目列表</div>
        <div class="content">
            <form action="/question/questions" method="post">
                <label class="ziti">
                    所属年级:
                    <select name="gradeId" class="layui-select x-select">
                        <option value="" ${(gradeId==-1)?string("selected","")}>全部</option>
                        <#list grades as grade>
                            <option value="${grade.gradeId}" ${(gradeId==grade.gradeId)?string("selected","")}>${grade.name}</option>
                        </#list>
                    </select>
                    评测对象:
                    <select name="teacherType" class="layui-select x-select">
                        <option value="" ${(teacherType==-1)?string("selected","")}>全部</option>
                        <option value="0" ${(teacherType==0)?string("selected","")}>教员</option>
                        <option value="1" ${(teacherType==1)?string("selected","")}>班主任</option>
                    </select>
                </label>
                <input class="layui-btn layui-btn-primary x-btn" value="搜索" type="submit"/>
            </form>

        </div>
    </header>
    <footer>

        <div>
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;" onclick="location.href='/question/savePage'">新增题目</button>
            </div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>创建时间</th>
                    <th>标题</th>
                    <th>说明</th>
                    <th>选项 / 分数</th>
                    <th>所属年级</th>
                    <th>评测对象</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list questions as question>
                    <tr>
                        <td>${question.createTime?datetime}</td>
                        <td>${question.title}</td>
                        <td>${question.direction}</td>
                        <td>
                            <#list question.options?eval as option>
                                <p>${option.detail}&nbsp;&nbsp;/&nbsp;&nbsp;${option.score} </p>
                            </#list>
                        </td>
                        <td>${question.gradeId}</td>
                        <td>${(question.teacherType==0)?string('教员','班主任')}</td>
                        <td><input type="button" onclick="location.href='/question/setPage?questionId=${question.questionId}'" class="layui-btn layui-btn-sm" value="修改"/>  <input type="button" onclick="del(${question.questionId})" class="layui-btn layui-btn-sm" value="删除"/></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </footer>
</div>
<script src="/layui/layui.js"></script>
</body>
</html>