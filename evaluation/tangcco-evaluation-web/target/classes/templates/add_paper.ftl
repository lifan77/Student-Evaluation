<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/jquery.min.js"></script>
    <script>
        function add() {
            $.ajax({
                type:"post",
                url: "save",
                dataType: "json",
                data:$("form").serialize(),
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
    <form>
            标题<input type="text" name="title">
            说明<input type="text" name="direction">
            评测班级<input type="text" name="classes">
            评测人员<input type="text" name="teacherType">
            开始时间<input type="text" name="beginTime">
            结束时间<input type="datetime-local" name="endTime">
    </form>
    <button onclick="add()">提交</button>
</body>
</html>