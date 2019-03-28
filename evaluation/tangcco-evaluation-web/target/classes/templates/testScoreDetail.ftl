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
    <footer>
        <div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>【
                <tr>
                    <th>题号</th>
                    <th>问题</th>
                    <th>分数</th>
                </tr>
                </thead>
                <tbody>
                <#list detail as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.wenti}</td>
                    <td>${item.daan}</td>
                </tr>
                </#list>
                </tbody>
            </table>
            <button onclick="window.location.href='/paper/totestScore?pid=${pid}&cid=${cid}'" class="layui-btn layui-btn" style="float: right">返回</button>
            <div id="page" class="fenye"></div>
        </div>
    </footer>

</div>
</body>
</html>