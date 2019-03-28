<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/css/Xq.css">
    <script src="../js/jquery-1.12.4.js"></script>

</head>
<body>

<div class="overall">
    <header>
        <div class="daohang">法规管理 / 法规列表</div>
        <div class="title">法规列表</div>
        <div class="content">
            <label class="ziti">
                *问卷标题:
                <select class="layui-input x-input" name="pid" id="classOption" onchange="bian(this)">

                </select>
            </label>
            <label class="ziti">
                *评测班级:
                <select class="layui-input x-input" name="cid" id="teacherOption" >

                </select>
            </label>
            <button class="layui-btn layui-btn-primary x-btn"  onclick="imga()">搜索</button>
        </div>
    </header>
  <footer  style="display: none">

        <div>
            <h1 id="tType"></h1>
            <div class="layui-input-block">


                <span id="avg" class="layui-btn layui-btn-normal" style="float: right;" ></span>
            </div>
            <table id="showTable" class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>匿名名称</th>
                    <th>总分数</th>
                    <th>意见反馈</th>
                    <th>交卷时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <div id="page" class="fenye"></div>
        </div>
    </footer>
</div>

<div align="center" id="imgPhoto">
<img src="/img/YaoTou.gif">
    <h2 id="mess">请选择问卷标题</h2>
</div>
<input type="hidden" id="pid" value="${pid}"/>
<input type="hidden" id="cid" value="${cid}"/>
<script src="/layui/layui.js"></script>
<script>



    function showClassList(){
        $.post("getPapers",function(data){
            var con="<option value='0'>--请选择--</option>";
            for(var i=0;i<data.length;i++){
                    if(data[i].paperId==$("#pid").val()){
                        con+="<option value='"+data[i].paperId+"' selected>"+data[i].title+"</option>"
                    }else{
                        con+="<option value='"+data[i].paperId+"'>"+data[i].title+"</option>"
                    }


            }
            $("#classOption").html(con);
        },"json")
    }
    function bian(dom){
        var pId=$(dom).val();
        $.post("getPaperClasses","pid="+pId,function(data){
            var con="<option value='0'>--请选择--</option>";
            for(var i=0;i<data.length;i++){
                if(data[i].classId==$("#cid").val()){
                    con+="<option value='"+data[i].classId+"' selected>"+data[i].name+"</option>";
                }else{
                    con+="<option value='"+data[i].classId+"'>"+data[i].name+"</option>";
                }

            }

            $("#teacherOption").html(con);
        },"json");

    }

    function imga(){
        var pid=$("#classOption").val();
        var cid=$("#teacherOption").val();
        f5(cid,pid)
    }

    function f5(cid,pid) {
        $.post("../toAnswerList",{"cid":cid,"pid":pid},function(data){
            if(data.list!=null && data.list!=""){
                $.get("../getTeacher",{"tid":data.list[0].teacherId},function (data) {
                    if(data.type==0){
                        $("#tType").text("教员:"+data.name);
                    }else{
                        $("#tType").text("班主任:"+data.name);
                    }
                })
                var dom="";
                for(var i=0;i<data.list.length;i++){
                    dom+="<tr>";
                    dom+="<td>"+data.list[i].nickname+"</td>";
                    dom+="<td>"+data.list[i].totalScore+"</td>";
                    dom+="<td>"+data.list[i].opinion+"</td>";
                    dom+="<td>"+data.list[i].createTime+"</td>";
                    dom+="<td><a href=\"../getAnswerDetail?cid="+cid+"&pid="+pid+"&aid="+data.list[i].answerId+"&tid="+data.list[i].teacherId+"\" class=\"caozuo\">查看</a></td>";
                    dom+="</tr>";
                }
                $("#showTable tbody").html(dom);
                $("#avg").text("平均分:"+data.avgScore+"分");
            }else{
                /*var dom="<tr></tr>";
                $("#showTable tbody").html(dom);*/
                $("#mess").text("没有内容");
                document.getElementById("imgPhoto").style.display="block";
                document.getElementsByTagName("footer")[0].style.display="none";
            }
        },"json")
        document.getElementById("imgPhoto").style.display="none";
        document.getElementsByTagName("footer")[0].style.display="block";
    }
    $(function(){

        showClassList();

        var cid=$("#cid").val();
        var pid=$("#pid").val();

        if(pid!=0 && cid!=0  ){
            bian($("#pid"));
            f5($("#cid").val(),$("#pid").val())

        }

    })

</script>
</body>
</html>