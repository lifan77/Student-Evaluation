<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="/js/jquery.min.js"></script>
    <script>
        function chk() {
            $("#classes").html("");
            $.ajax({
                type: "get",
                url: "/class/classes?gradeId=" + $("select[name='gradeId']").val(),
                dataType: "json",
                success: function (data) {
                    $.each(data, function (i, v) {
                        var input = "<input type='checkbox' name='class' value='" + v.classId + "'/>" + "<span>" + v.name + "</span>    ";
                        if ((i + 1) % 3 != 0) {
                            $("#classes").append(input)
                        } else {
                            $("#classes").append(input + "<br>")
                        }

                    })
                },
                error: function () {
                    alert("系统异常");
                }
            });
        }

        function add() {
            var classes = {"gradeId": $("select[name='gradeId']").val(), "classes": []};
            var obj = {"classId": "", "name": ""};
            $("input[type=checkbox]:checked").each(function (i, v) {
                obj.classId = v.value;
                obj.name = v.nextElementSibling.innerHTML;
                classes.classes.push(JSON.parse(JSON.stringify(obj)));
            })
            $.ajax({
                type: "post",
                url: "save",
                dataType: "json",
                data: $("form").serialize() + "&classes=" + JSON.stringify(classes),
                success: function (data) {
                    if (data.flag) {
                        alert(data.message);
                        window.location.href = "/paper/papers";
                    } else {
                        alert(data.message);
                    }
                },
                error: function () {
                    alert("系统异常");
                }
            });
        }

        $(function () {
            chk();
        })
    </script>
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">测评管理 / 新增测评</div>
        <div class="title">新增测评</div>
    </header>
    <footer>
        <div align="center">
            <form>
                <table class="biaodan" cellspacing="10px">

                    <tr>
                        <td>标题</td>
                        <td><input type="text" name="title" class="layui-input x-input"></td>
                    </tr>
                    <tr>
                        <td>说明</td>
                        <td><input type="text" name="direction" class="layui-input x-input"></td>
                    </tr>
                    <tr>
                        <td>评测年级</td>
                        <td>
                            <select name="gradeId" class="layui-select x-select" onchange="chk()">
                            <#list grades as grade>
                                <option value="${grade.gradeId}">${grade.name}</option>
                            </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>评测班级</td>
                        <td id="classes">
                        </td>
                    </tr>
                    <tr>
                        <td>评测人员</td>
                        <td>
                            <select name="teacherType" class="layui-select x-select">
                                <option value="0">教员</option>
                                <option value="1">班主任</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>开始时间</td>
                        <td><input type="datetime-local" name="begin" class="layui-input x-input"></td>
                    </tr>
                    <tr>
                        <td>结束时间</td>
                        <td><input type="datetime-local" name="end" class="layui-input x-input"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;">
                            <input type="button" onclick="add()" class="layui-btn layui-btn-primary x-btn"
                                   style="margin-top: 20px;" value="保存">
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