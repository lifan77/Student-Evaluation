<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		body{width: 100%;}
		header{width: 100%;height: 100px;background-color: white;box-shadow: 0px 5px 5px lightgray;}
		header span{color: gray;font-size: 35px;position: relative;top: 20px;}
		.bgImg{width:100%;height:400px;background: url(/img/256930-1F51214450737.jpg);background-attachment: fixed;box-shadow: 0px 5px 5px lightgray;}
		.TeacherType{font-size:25px;padding: 10px 20px;border-radius: 50px;background-color: rgba(255,255,255,0.8);color:royalblue;display: block;width: 30%;position: relative;top: 300px;}
		.TeacherName{display: block;font-size: 30px;color: rgba(255,255,255,0.8);}
		.TeacherNameText{display: block;font-size: 60px;color: white;position: relative;top: 20px;}
		.SUBJECT{width: 100%;height: 400px;margin-top: 20px;position: relative;border-bottom: 1px solid gray;}
		
		.TitleNumber{display: block;width: 40px;height: 40px;background-color: dodgerblue;border-radius: 50%;color: white;border:2px solid cornflowerblue;position: absolute;top: 30px;left: 30px;}
		.TitleNumber>span{position: relative;top: 5px;font-size: 20px;}
		.NumberText{font-size: 35px;position: absolute;top: 27px;left: 100px;width: 90%;}
		.option{
			width: 95%;
			margin-top: 30px;
		}
		.option>div{display: inline-block;color: white;border-radius: 10px;transition: background-color ease 1s;}
		.option>div:nth-child(1){width: 45%;height: 80px;background-color: rgb(37,224,195);margin: 10px;}
		.option>div:nth-child(2){width: 45%;height: 80px;background-color: rgb(255,129,79);margin: 10px;}
		.option>div:nth-child(3){width: 45%;height: 80px;background-color: rgb(254,212,49);margin: 10px;}
		.option>div:nth-child(4){width: 45%;height: 80px;background-color: rgb(255,71,97);margin: 10px;}
		.option>div:nth-child(5){width: 45%;height: 80px;background-color: rgb(51,63,85);margin: 10px;}
		.option>div>span{position: relative;top: 15px;font-size: 25px;}
		.option>div:hover{background-color: cornflowerblue;transition: background-color ease 1s;cursor: pointer;}
		.numberDiv{position: absolute;left: 30px;bottom: 30px;}
		.number{font-size: 30px;display: inline-block;margin: 0px 5px;color: cornflowerblue;}
		.submit{outline:none;width: 80%;height: 100px;display: block;font-size: 60px;margin: 30px;color: white;border: 1px solid dodgerblue;background-color: dodgerblue;border-radius: 50px;}
		.NickNameInput{width: 50%;height: 50px;display: block;font-size: 25px;outline: none;text-align: center;display:block;margin: 30px;color: cornflowerblue;border-radius: 50px;border:1px solid cornflowerblue;background-color: white;}
		textarea{
			width: 80%;
			height: 100px;
			font-size: 25px;
			display: block;
			margin: 30px 0px;
			border-radius:10px;
			outline:none;
			border: 1px solid cornflowerblue;
			padding: 20px;
		}
	</style>
	
	<body>
		<header>
			<div align="center">
				<span>学生答题</span>
			</div>
		</header>
		<div class="bgImg" align="center">
			<span class="TeacherType">测评教师类型 : ${teacher.type}</span>
			<span class="TeacherName">测评教师姓名</span>
			<span class="TeacherNameText">${teacher.name}</span>
		</div>
		<section>
			<#list map?keys as key>
			<div align="center" class="SUBJECT rb" id="rb-${key_index+1}">     <#--整个题目的div-->
					<div class="TitleNumber"><span>${key_index+1}</span></div><#--这里是题目的序号-->
					<div class="NumberText" align="left">
						<p align="left" class="rb-${key_index+1}">${key}</p><#--这里是题目-->
						<div class="option"  align="center">
							<#list map[key]?keys as yy>
								<#--onclick="numb(${map[key][yy]},this)"-->
							<div  onclick="numb(${map[key][yy]},this)" data-value=${map[key][yy]} class="rb-tab "><span >${yy}</span></div><#--这里是每一个选项-->
							</#list>
						</div>
					</div>

			<p class="numberDiv">
					分数:<span class="number" id="fenshu">-</span>分
			</p>
			</div>
			</#list>
		</section>
		<footer>
			<div align="center">
				<form action="submitExam" method="post">
					<textarea class="detail" placeholder="请输入您对老师的意见或建议" name="option"></textarea>
					<input type="text" name="nickName" class="NickNameInput" placeholder="请输入您的匿名名称"/>
					<input type="hidden" id="detail" name="detail">
					<input type="hidden" id="score" name="score">

				</form>
				<button class="submit">提交</button>
			</div>
		</footer>
	</body>
	<script type="text/javascript" src="/js/jquery-1.8.3.min.js" ></script>
	<#--<script type="text/javascript">
		//转换为json的字符串
		var JsonStr="[";
		var soure=[];
		$(function(){
			//表单提交
			$("form").submit(function(){
				//判断各个分数中是否包含为选择的题目;$(".number").text()的弹框是各题分数的总字符串(截取如果出现0那么这道题是未选择的)
				if($(".number").text().indexOf("-")>=0){
					alert($(".number").text());
					//提示哪道题未选择并阻止表单提交
					alert("第"+($(".number").text().indexOf("-")+1)+"道题未选择，请选择后提交");
					return false;
				}else{
					JsonStr+="]";
					alert(JsonStr);
					alert("提交");
					return true;
				}
			});
		});
		//选择选项后的事件
		function numb(index,dom){
		 $(dom).parent().parent().parent().children("p").children("span").text(index);
            $(this).addClass("rb-tab-active");
			//每次选择后显示分数
			$(dom).parent().parent().parent().children("p").children("span").text(index);
			//获取题目
			alert($(dom).parent().prev().text());
			//获取题号
			alert($(dom).parent().parent().prev().children("span").text());
			//获取分数
			alert(index);
			soure+=index
			//将分数添加在数组中
			JsonStr+="{'id':"+$(dom).parent().parent().prev().children("span").text()+",'wenti':'"+$(dom).parent().prev().text()+"','daan':"+index+"}";
		}
	</script>-->
	<script src="/layui/layui.all.js"></script>
	<script>
        var msg="${msg?default('')}";
        if(msg.length!=0){
            layer.msg(msg);
        }
        var survey = []; //Bidimensional array: [ [1,3], [2,4] ]
       /* $(".rb-tab").click(function(index){
           // $(this).parent().find(".rb-tab").removeClass("rb-tab-active");});*/
       function numb(index,dom){
           $(dom).parent().children("div").removeClass("rb-tab-active")
           $(dom).addClass("rb-tab-active");
           $(dom).parent().parent().parent().children("p").children("span").text(index);
	   }

        $(function() {
            //表单提交
            $(".submit").click(function () {
                //判断各个分数中是否包含为选择的题目;$(".number").text()的弹框是各题分数的总字符串(截取如果出现0那么这道题是未选择的)
                if ($(".number").text().indexOf("-") >= 0) {
                    //提示哪道题未选择并阻止表单提交
                    alert("第" + ($(".number").text().indexOf("-") + 1) + "道题未选择，请选择后提交");
                } else {
                        for (i = 1; i <= $(".SUBJECT").length; i++) {
                            var rb = "rb" + i;
                            var rbValue = parseInt($(".rb-tab").parent().parent().parent().children("p").children("span").text().substring(i - 1, i));
                            var wenti = $("#rb-" + i).find(".rb-tab-active").children("span").text();
                            survey.push([i, wenti, rbValue]); //Bidimensional array: [ [1,3], [2,4] ]
                        }
                        debug();
                    $("form").submit();
                }
            });

        });
        function debug() {
            var debug1 = "";
            var score = 0;
            var nickname = $("#nickName").val();
            var option = $("#option").val();
            for (i = 0; i < survey.length; i++) {
                debug1 += "{'id':" + survey[i][0] + " ,'wenti':" + "'" + survey[i][1] + "'" + ",'daan':" + survey[i][2] + "},";
                console.log("{'id':" + survey[i][0] + " ,'wenti':" + survey[i][1] + ",'daan':" + survey[i][2] + "},")
                score += survey[i][2];
                //[{'id':1,'wenti':'这是第一题的内容','daan':5},{'id':2,'wenti':'这是第二题的内容','daan':5},{'id':3,'wenti':'这是第三题的内容','daan':5}]
            };
            $("#detail").val(debug1);
            $("#score").val(score);

        }


       /*
               function submit() {
                   $(".chenjanghong").submit();
               }*/
	</script>
</html>
