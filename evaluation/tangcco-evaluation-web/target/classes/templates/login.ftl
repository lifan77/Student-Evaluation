<!DOCTYPE html>
<html>
<head>
    <title>课工场教师评测系统-教务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Flaty User login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <link href="style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- //Custom Theme files -->
    <!-- js -->
    <script src="/js/jquery-1.12.4.js"></script>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Custom Theme files -->

    <!-- //js -->
    <!-- web font -->
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!--web font-->
    <!-- //web font -->
</head>
<body>
<!-- main -->
<div class="main-agileits">
    <h1>课工场教师评测系统-教务</h1>
    <div class="mainw3-agileinfo form">
        <div id="login">
            <a style="color: whitesmoke" id="errorColor"><#if error??>${error}</#if></a>
            <form action="/adminLogin" method="post" id="login_form">
                <div class="field-wrap">
                    <label> 编号<span class="req">*</span> </label>
                    <input type="text" required autocomplete="off" name="roleId" id="roleId"/>
                </div>
                <div class="field-wrap">
                    <label> 密码<span class="req">*</span> </label>
                    <input type="password" required autocomplete="off" name="password" id="password"/>
                </div>
                <!--<p class="forgot"><a href="#">忘记密码？</a></p>-->
            <#-- <label><input type="checkbox" id="remeberyhm">记住用户名</label>-->
                <button class="button button-block" onclick="show()"/>
                登录</button>
            </form>
        </div>

    </div>
</div>
<!-- //main -->
<!-- copyright -->
<div class="w3copyright-agile">
    <p>&copy; Copyright &copy; 2019-2029<a href="#" target="_blank">W3layouts</a></p>
</div>
<!-- //copyright -->

<script>

    function show() {
        var phone = $("#roleId").val();
        var pass = $("#password").val();
        //非空验证
        if (phone == '' && pass == '') {
            alert("手机号或者密码为空");
        }




    }

    //登录按钮与键盘回车绑定
    function IsEnterKeyPress() {
        var lKeyCode = (navigator.appname == "Netscape") ? event.which : window.event.keyCode;
        if (lKeyCode == 13) {
            show();
        }
    }


    /*$(function () {
        var yhm = $.cookie('admPhone');
        var mm = $.cookie('password');
        //页面加载的时候从cookie中取出用户名和密码填充对应的输入框
        $('#admPhone').val(yhm);
        $("#password.val(mm);
        if(yhm != null && yhm != '' && mm != null && mm != ''){
            $("#remeberyhm").attr('checked',true);		}
    });


        function remeber() {
            var yhm = $("#admPhone").val();
            var mm = $("#password").val();
            //判断复选框的选择状态添加cookie
            if ($("#remeberyhm").is(":checked")) {
                //存储一个带7天期限的cookie    	　　　
                $.cookie("yhm", yhm, {expires: 7});
                $.cookie("mm", mm, {expires: 7});
            } else {
                $.cookie("yhm", "", {expires: -1});
                $.cookie("mm", "", {expires: -1});
            }
            //提交表单
            $("#login_form").submit();
        };
*/

</script>
<script>
    $(function () {

        $('.form').find('input, textarea').on('keyup blur focus', function (e) {
            var $this = $(this),
                    label = $this.prev('label');

            if (e.type === 'keyup') {
                if ($this.val() === '') {
                    label.removeClass('active highlight');
                } else {
                    label.addClass('active highlight');
                }
            } else if (e.type === 'blur') {
                if ($this.val() === '') {
                    label.removeClass('active highlight');
                } else {
                    label.removeClass('highlight');
                }
            } else if (e.type === 'focus') {

                if ($this.val() === '') {
                    label.removeClass('highlight');
                }
                else if ($this.val() !== '') {
                    label.addClass('highlight');
                }
            }
        })
    });
</script>
</body>
</html>