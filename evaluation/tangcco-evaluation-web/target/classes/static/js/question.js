function add(event) {
    $("table[class='biaodan']").append(" <tr >\n" +
        "                        <td>选项</td>\n" +
        "                        <td><input type=\"text\" name=\"option\" class=\"layui-input x-input\" placeholder=\"选项\"><br>\n" +
        "                            <input type=\"text\" name=\"score\" class=\"layui-input x-input\" placeholder=\"分数\">\n" +
        "                            <input type=\"button\" onclick=\"rm(this)\" value=\"-\" class=\"layui-btn layui-btn-sm\" style=\"margin-left: -30px;margin-top: -30px\"/>\n" +
        "                        </td>\n" +
        "                    </tr>")
}
function rm(event) {
    event.parentNode.parentElement.parentElement.removeChild(event.parentNode.parentElement);
}
function save() {
    var options=[]
    var obj={"detail":"","score":""}
    $("input[name='option']").each(function (i,v) {
        obj.detail=v.value;
        obj.score=v.nextElementSibling.nextElementSibling.value;
        options.push(JSON.parse(JSON.stringify(obj)));
    })
    $.ajax({
        type: "post",
        url: "save",
        dataType: "json",
        data: $("#saveForm").serialize()+"&options="+JSON.stringify(options),
        success: function (data) {
            if (data.flag) {
                layer.msg('保存成功!',{icon : 1,time:1500,end: function () {window.location.href = "/question/questions"}});
            } else {
                alert(data.message);
            }
        },
        error: function () {
            layer.msg('系统异常!',{time:1500});
        }
    });
}
