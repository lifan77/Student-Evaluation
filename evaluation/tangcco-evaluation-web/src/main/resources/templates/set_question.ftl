<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/question.js"></script>
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">题库管理 / 题目管理</div>
        <div class="title">题目管理</div>
    </header>
    <footer>
        <div align="center">
            <form id="saveForm">
                <table class="biaodan" cellspacing="10px">
                    <input type="hidden" name="questionId" value="${question.questionId}"/>
                    <input type="hidden" name="time" value="${question.createTime?datetime}"/>
                    <tr>
                        <td>标题</td>
                        <td><input type="text" name="title" class="layui-input x-input" value="${question.title}"></td>
                    </tr>
                    <tr>
                        <td>说明</td>
                        <td><input type="text" name="direction" class="layui-input x-input"
                                   value="${question.direction}"></td>
                    </tr>
                    <tr>
                        <td>评测年级</td>
                        <td>
                            <select name="gradeId" class="layui-select x-select">
                            <#list grades as grade>
                                <option value="${grade.gradeId}" ${(grade.gradeId == question.gradeId)?string("selected","") }>${grade.name}</option>
                            </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>评测对象</td>
                        <td>
                            <select name="teacherType" class="layui-select x-select">
                                <option value="0" ${(question.teacherType=0)?string("selected","")}>教员</option>
                                <option value="1" ${(question.teacherType=1)?string("selected","")}>班主任</option>
                            </select>
                        </td>
                    </tr>
                    <#list question.options?eval as option>
                    <tr >
                        <td>选项</td>
                        <td><input type="text" name="option" value="${option.detail}" class="layui-input x-input" placeholder="选项"><br>
                            <input type="text" name="score" value="${option.score}" class="layui-input x-input" placeholder="分数">
                            <input type="button" onclick="rm(this)" value="-" class="layui-btn layui-btn-sm" style="margin-left: -30px;margin-top: -30px"/>
                        </td>
                    </tr>
                    </#list>
                </table>
                <table>
                    <tr>
                        <td colspan="2" style="text-align: center;">
                            <input type="button" class="layui-btn layui-btn-primary x-btn" style="margin-top: 20px;"onclick="add()" value="添加选项"/>
                            <input type="button" class="layui-btn layui-btn-primary x-btn" style="margin-top: 20px;"onclick="save()" value="保存"/>
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
<script>
    $(function () {
        $('div#froala-editor').froalaEditor({
            dragInline: true,
            toolbarButtons: ['bold', 'italic', 'underline', 'insertImage', 'insertLink', 'undo', 'redo'],
            height: 300
        })
    });
    layui.use('form', function () {
        var form = layui.form;

    });
    layui.use('upload', function () {
        var $ = layui.jquery
                , upload = layui.upload;
        upload.render({
            elem: '#shangchuan'
            , url: '/upload/'
            , done: function (res) {
                console.log(res)
            }
        });
    })
</script>

</body>
</html>