<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="/layui/layui.all.js"></script>
    <script src="/js/jquery.min.js"></script>
    <script>
        function del(questionId) {
            $.ajax({
                type:"post",
                url: "delete?questionId="+questionId,
                dataType: "json",
                success: function (data) {
                    if (data.flag) {
                        layer.msg(data.message,{icon : 1,time:1500,end: function () {location.reload();}});
                    }
                },
                error: function () {
                    layer.msg('系统异常!',{time:1500});
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
                        <#list grades as grade>
                            <option value="${grade.gradeId}" ${(gradeId==grade.gradeId)?string("selected","")}>${grade.name}</option>
                        </#list>
                    </select>
                    评测对象:
                    <select name="teacherType" class="layui-select x-select">
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
                    <th>标题</th>
                    <th>选项一 / 分数</th>
                    <th>选项二 / 分数</th>
                    <th>选项三 / 分数</th>
                    <th>选项四 / 分数</th>
                    <#if questions?size!=0>
                        <#if questions[0].getTeacherType()==0>
                            <th>选项五 / 分数</th>
                        </#if>
                    </#if>
                    <th>所属年级</th>
                    <th>评测对象</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list questions as question>
                    <tr>
                        <td>${question.title}</td>
                        <#list question.options?eval as option>
                            <td>${option.detail}&nbsp;&nbsp;/&nbsp;&nbsp;${option.score}</td>
                        </#list>
                        <#if questions[0].getTeacherType()==0>
                            <#assign number=5 />
                        <#else>
                            <#assign number=4 />
                        </#if>
                        <#if question.options?eval?size % number != 0>
                            <#list 1..(number-question.options?eval?size) as num>
                                <td>/</td>
                            </#list>
                        </#if>
                        <td>${question.gradeId}</td>
                        <td style="width: 50px;">${(question.teacherType==0)?string('教员','班主任')}</td>
                        <td style="width: 120px"><input type="button" onclick="location.href='/question/setPage?questionId=${question.questionId}'" class="layui-btn layui-btn-sm" value="修改"/>  <input type="button" onclick="del(${question.questionId})" class="layui-btn layui-btn-sm" value="删除"/></td>
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