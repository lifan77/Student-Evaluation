<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1px">
        <tr>
            <th>问卷ID</th>
            <th>标题</th>
            <th>说明</th>
            <th>评测班级</th>
            <th>评测人员</th>
            <th>创建时间</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        <#list papers as paper>
            <tr>
                <td>${paper.paperId}</td>
                <td>${paper.title}</td>
                <td>${paper.direction}</td>
                <td>
                     <#list paper.classes?eval as class>
                         ${class.name}
                     </#list>
                </td>
                <td>${(paper.teacherType==0)?string('教员','班主任')}</td>
                <td>${paper.createTime?datetime}</td>
                <td>${paper.beginTime?datetime}</td>
                <td>${paper.endTime?datetime}</td>
            </tr>
        </#list>
</table>
</body>
</html>