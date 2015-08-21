// JavaScript Document

jQuery.extend({
	//初始化左侧布局
	initLayoutLeft:function(zhuId,ziId){
		var _num = 1;
		var __num;
		var _zhuId = zhuId;
		var _ziId = ziId;
		
		$("#" + _zhuId).find(".layout_left_title").addClass("layout_left_navcurrent");
		$("#" + _ziId).addClass("layout_left_zinavcurrent");
		$(".layout_left_zinavcurrent").parent().show();
		$(".layout_left_title").click(function(){
			_num = 1;
			__num = $(this).parent().find(".layout_left_main").attr("uid");
			if(_num != __num){
				$(".layout_left_main").slideUp();
				$(this).parent().find(".layout_left_main").slideDown();
				$(".layout_left_main").attr("uid","2");
				$(this).parent().find(".layout_left_main").attr("uid","1");
			}
		});

		$(".layout_left_title_zi").click(function(){
			$(".layout_left_title_zi").removeClass("layout_left_zinavcurrent");
			$(this).addClass("layout_left_zinavcurrent");
		});
	},
	//初始化右侧布局
	initLayoutRight:function(){
		$(".layout_content").scroll(function(){
			var _bodyScrollTop = document.getElementById("layout_right").scrollTop;
			if (_bodyScrollTop > 0) {
				$("#layout_right").addClass("box_shadow_top");
			}else{
				$("#layout_right").removeClass("box_shadow_top");
			};
		});
	},
	//修改密码弹窗
	dialog:function(){
		$("#change_pwd").on("click",function(){
			$.layer({
			    type: 1,
			    shade: [0.58, '#000',true],
			    area: ['400px', '200px'],
			    title: "修改密码",
			    border: [10, 0.3, '#000'],
			    page: {dom : '#change-dialog-form'},
			    btns: 2,
			    btn: ['确定', '取消'],
			    success: function(layero){
			    	$(".change-dialog-form-cover").removeClass("hide");			    	
			    },
			    yes:function(index){
			    	var oldpwd = $(".oldpwd").val();
			    	var newpwd = $(".newpwd").val();
			    	var confirmpwd = $(".comfirmpwd").val();
			    	if(oldpwd && newpwd && confirmpwd){
			    		
			    	}else if(newpwd.length < 6){
			    		alert("密码不能小于6位");
			    	}
			    	else{
			    		alert("请填写完整修改密码信息");
			    		return 
			    	}
			    	if(oldpwd == newpwd){
			    		alert("新旧密码不能相同")
			    	}else{
			    		if(confirmpwd == newpwd){
			    			var _url = domainUrl+"/manage/updataPass.do";
			    			$.ajax({
					    		url: _url,
			    				type:"post",
					    		data:{"oldPass":oldpwd,"newPass":newpwd},
					    		success:function(data){
					    			if(data == "-3"){
					    				alert("原密码错误");
					    			}
					    			if(data > 0){
					    				layer.close(index);
					    				alert("修改成功");
					    			}
					    		}
					    	});
			    		}else{
			    			alert("新密码不一致")
			    		}
			    	}
			    },
			    end: function(){
			    	$("#change-pwd-form")[0].reset();
			    }
			});	
		});
	}
})

$(document).ready(function(){
	$.initLayoutRight();
	$.dialog();
    var _rightHeight = $(".layout_left").height() - 130;
    $(".layout_right").height(_rightHeight);
});