<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/assets/common/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/assets/manage/css/login.css"/>
    <script src="${request.contextPath}/assets/common/js/jquery-1.9.1.min.js"></script>
    <script>
        var domainUrl = "${request.contextPath}";
    </script>
    <title>${basename}</title>
</head>

<body>
	<div class="login_wrap">
		<div class="login_title">
            移动云商管理系统
		</div>
		<div class="login_form_wrap">
			<form class="login_form">
				<div class="clearfix login_form_item">
					<label class="login_tlt"><em>*</em>用户名</label>
					<input type="text" placeholder="用户名" class="login_input login_name" tag="login_name" nullmsg = "请填写用户名" errormsg="用户名错误！"/>
					<span class="login_error_tips"></span>
				</div>
				<div class="clearfix login_form_item">
					<label class="login_tlt"><em>*</em>密码</label>
					<input type="password"  placeholder="密码" class="login_input login_password" tag="login_password" nullmsg = "请填写密码" errormsg="密码长度应为6~32个字符！"/>
					<span class="login_error_tips"></span>
				</div>
				<div class="clearfix login_form_item login_valid_item">
					<label class="login_tlt"><em>*</em>验证码</label>
					<input type="text" placeholder="验证码" class="login_input login_valid" name="vcode" tag="login_valid" nullmsg = "请填写验证码" errormsg="验证码错误！"/>
					<a href="javascript:void(0);"  id="change_vcode">
						<img src="${request.contextPath}/verifyCode.mvv" id="imgObj" onclick="changeImg()"/>
					</a>
					<span class="login_error_tips">
						验证码必填！
					</span>
				</div>
			</form>
		</div>
		<div class="login_bottom">
			<p class="clearfix">
				<a href="javascript:void(0);" class="login_btn right">登录</a>
			</p>	
		</div>
	</div>
	<script type="text/javascript" src="${request.contextPath}/assets/manage/js/login.js"></script>
</body>
</html>