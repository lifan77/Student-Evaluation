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
		.bgImg{width:100%;height:400px;background: url(img/256930-1F51214450737.jpg);background-attachment: fixed;box-shadow: 0px 5px 5px lightgray;}
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
		.option>div:nth-child(1){width: 25%;height: 80px;background-color: rgb(37,224,195);margin: 10px;}
		.option>div:nth-child(2){width: 25%;height: 80px;background-color: rgb(255,129,79);margin: 10px;}
		.option>div:nth-child(3){width: 25%;height: 80px;background-color: rgb(254,212,49);margin: 10px;}
		.option>div:nth-child(4){width: 38%;height: 80px;background-color: rgb(255,71,97);margin: 10px;}
		.option>div:nth-child(5){width: 38%;height: 80px;background-color: rgb(51,63,85);margin: 10px;}
		.option>div>span{position: relative;top: 15px;font-size: 30px;}
		.option>div:hover{background-color: cornflowerblue;transition: background-color ease 1s;cursor: pointer;}
		.numberDiv{position: absolute;left: 30px;bottom: 30px;}
		.number{font-size: 30px;display: inline-block;margin: 0px 5px;color: cornflowerblue;}
		.submit{outline:none;width: 80%;height: 100px;display: block;font-size: 60px;margin: 30px;color: white;border: 1px solid dodgerblue;background-color: dodgerblue;border-radius: 50px;}
		.NickNameInput{width: 50%;height: 50px;display: block;font-size: 30px;outline: none;text-align: center;display:block;margin: 30px;color: cornflowerblue;border-radius: 50px;border:1px solid cornflowerblue;background-color: white;}
	</style>
	
	<body>
		<header>
			<div align="center">
				<span>学生答题</span>
			</div>
		</header>
		<div class="bgImg" align="center">
			<span class="TeacherType">测评教师类型 : 班主任</span>
			<span class="TeacherName">测评教师姓名</span>
			<span class="TeacherNameText">何子龙</span>
		</div>
		<section>

			<div align="center" class="SUBJECT">
				<#list map?keys as key>
					<div class="TitleNumber"><span>${key_index+1}</span></div>
					<div class="NumberText" align="left">
						<p align="left">${key}</p>
						<div class="option" align="center">
							<#list map[key]?keys as yy>
							<div onclick="numb(${map[key][yy]},this)"><span>${yy}</span></div>
							</#list>
							<!--<div onclick="numb(4,this)"><span>一般般</span></div>
							<div onclick="numb(3,this)"><span>还行</span></div>
							<div onclick="numb(2,this)"><span>不太行</span></div>
							<div onclick="numb(1,this)"><span>太差了</span></div>-->
						</div>
					</div>
				</#list>
			<p class="numberDiv">
					分数:<span class="number">0</span>分
			</p>
			</div>
			<!--<div align="center" class="SUBJECT">
				<div class="TitleNumber"><span>1</span></div>
				<div class="NumberText" align="left">
					<p align="left">你觉得你的老师对于一些表现差劲的学生的态度如何?</p>
					<div class="option" align="center">
						<div onclick="numb(5,this)"><span>做的非常好</span></div>
						<div onclick="numb(4,this)"><span>一般般</span></div>
						<div onclick="numb(3,this)"><span>还行</span></div>
						<div onclick="numb(2,this)"><span>不太行</span></div>
						<div onclick="numb(1,this)"><span>太差了</span></div>
					</div>
				</div>
				<p class="numberDiv">
					分数:<span class="number">0</span>分
				</p>
			</div>
			<div align="center" class="SUBJECT">
				<div class="TitleNumber"><span>1</span></div>
				<div class="NumberText" align="left">
					<p align="left">你觉得你的老师对于一些表现差劲的学生的态度如何?</p>
					<div class="option" align="center">
						<div onclick="numb(5,this)"><span>做的非常好</span></div>
						<div onclick="numb(4,this)"><span>一般般</span></div>
						<div onclick="numb(3,this)"><span>还行</span></div>
						<div onclick="numb(2,this)"><span>不太行</span></div>
						<div onclick="numb(1,this)"><span>太差了</span></div>
					</div>
				</div>
				<p class="numberDiv">
					分数:<span class="number">0</span>分
				</p>
			</div>
			<div align="center" class="SUBJECT">
				<div class="TitleNumber"><span>1</span></div>
				<div class="NumberText" align="left">
					<p align="left">你觉得你的老师对于一些表现差劲的学生的态度如何?</p>
					<div class="option" align="center">
						<div onclick="numb(5,this)"><span>做的非常好</span></div>
						<div onclick="numb(4,this)"><span>一般般</span></div>
						<div onclick="numb(3,this)"><span>还行</span></div>
						<div onclick="numb(2,this)"><span>不太行</span></div>
						<div onclick="numb(1,this)"><span>太差了</span></div>
					</div>
				</div>
				<p class="numberDiv">
					分数:<span class="number">0</span>分
				</p>
			</div>-->
		</section>
		<footer>
			<div align="center">
				<form action="###" method="post">
					<input type="text" name="nickName" class="NickNameInput" placeholder="请输入您的匿名名称"/>
					<button class="submit">提交</button>
				</form>
			</div>
		</footer>
	</body>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
	<script type="text/javascript">
		//转换为json的字符串
		var JsonStr="[";
		$(function(){
			//表单提交
			$("form").submit(function(){
				//判断各个分数中是否包含为选择的题目;$(".number").text()的弹框是各题分数的总字符串(截取如果出现0那么这道题是未选择的)
				if($(".number").text().indexOf("0")>=0){
					alert($(".number").text());
					//提示哪道题未选择并阻止表单提交
					alert("第"+($(".number").text().indexOf("0")+1)+"道题未选择，请选择后提交");
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
			//每次选择后显示分数
			$(dom).parent().parent().parent().children("p").children("span").text(index);
			//获取题目
			alert($(dom).parent().prev().text());
			//获取题号
			alert($(dom).parent().parent().prev().children("span").text());
			//获取分数
			alert(index);
			
			//将分数添加在数组中
			JsonStr+="{'id':"+$(dom).parent().parent().prev().children("span").text()+",'wenti':'"+$(dom).parent().prev().text()+"','daan':"+index+"}";
		}
	</script>
</html>
