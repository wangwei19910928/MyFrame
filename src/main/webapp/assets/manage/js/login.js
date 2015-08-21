function changeImg() {
	var imgSrc = $("#imgObj");
	var src = imgSrc.attr("src");
	imgSrc.attr("src", chgUrl(src));
}
// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
	return url + "?timestamp=" + (new Date()).valueOf();
}
// function isRightCode(){
// var code = $("#veryCode").attr("value");
// code = "c=" + code;
// $.ajax({
// type:"POST",
// url:"resultServlet/validateCode",
// data:code,
// success:callback
// });
// }
function callback(data) {
	$("#info").html(data);
}
// 文本框失去焦点时验证
$(".login_input").blur(function() {
	var self = this;
	loginVlide(self);
});
// 登陆验证方法，验证的内容写在这里
function loginVlide(self) {
	var curVal = $.trim($(self).val());
	if (curVal.length > 0) {
		var tag = $(self).attr("tag");
		// 验证用户名
		if (tag == "login_name") {
			loginRight(self);
		}
		// 密码验证
		if (tag == "login_password") {
			var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,32}$/;
			if (reg.test(curVal)) {
				loginRight(self);
			} else {
				loginError(self, "密码长度应为6~32个字符！");
			}
		}
		// 验证验证码
		if (tag == "login_valid") {
			loginRight(self);
		}
	} else {
		var nullmsg = $(self).attr("nullmsg");
		loginError(self, nullmsg);
	}
}
// 验证错误
function loginError(self, msg) {
	$(self).siblings(".login_error_tips").html(msg).show();
	$(self).parent(".login_form_item").addClass("login_error");
}
// 验证通过
function loginRight(self) {
	$(self).siblings(".login_error_tips").hide();
	$(self).parent(".login_form_item").removeClass("login_error");
}
// 点击提交按钮
$(".login_btn")
		.click(
				function() {
					var loginInput = $(".login_input");
					$.each(loginInput, function() {
						var self = this;
						loginVlide(self);
					})
					// 是不是验证过了
					var loginVlided = $(".login_form_item").hasClass(
							"login_error") ? false : true;
					if (loginVlided) {
						var loginName = $(".login_name").val();// 用户名
						var loginPwd = $(".login_password").val();// 用户密码
						var loginCode = $(".login_valid").val();// 验证码
						$.ajax({
							url : domainUrl + '/login.mvv',
							data : {
								username : loginName,
								password : loginPwd,
								param : loginCode
							},
							dataType : 'json',
							success : function(data) {
								alert(data);
								if (data == 1) {
									window.location.href = domainUrl + "/manage/index.mvv"
								} else if (data == 0) {
									loginError($(".login_name"), "账号或者密码错误");
								} else {
									loginError($(".login_valid"), "验证码错误");
								}
							}
						})
					}
				});

document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13) {
		$(".login_btn").trigger("click");
	}
};