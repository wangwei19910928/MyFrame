<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script>
        var domainUrl = "${request.contextPath}";
    </script>
<script src="${request.contextPath}/assets/common/js/jquery-1.9.1.min.js"></script>
<script src="${request.contextPath}/assets/manage/js/layer/layer.min.js"></script>
<#include "/WEB-INF/pages/manage/base_js.ftl" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<script type="text/javascript">
	$().ready(function(){
		$.initLayoutLeft("","");
	})
</script>
<body>
	<div class="header"><!--header--> 
	<a href="${request.contextPath}/admin/index.do"></a>
	<span class="change_pwd"><em id="change_pwd">修改密码</em>　　<em onclick="window.location.href='${request.contextPath}/admin/logout.do'">安全退出</em></span>
</div>
<div class="change-dialog-form-cover hide">
	<div id="change-dialog-form">
	    <form class="form-wrap" id="change-pwd-form" style="font-size:12px;">
	      <div class="form-item  clearfix">
	          <label for="name"><span class="required">*</span> 原始密码：</label>
	          <input type="password" name="oldpwd" class="n-input oldpwd">
	          <span class="vlid_wrap"></span>
	      </div>
	      <div class="form-item  clearfix">
	          <label for="name"><span class="required">*</span> 新密码：</label>
	          <input type="password" name="newpwd" class="n-input newpwd">
	          <span class="vlid_wrap"></span>
	      </div>
	       <div class="form-item  clearfix">
	          <label for="name"><span class="required">*</span> 确认密码：</label>
	          <input type="password" name="comfirmpwd" class="n-input comfirmpwd">
	          <span class="vlid_wrap"></span>
	      </div>
	    </form>
	</div>
</div>

<!-- -->
<div class="layout_left"> <!--左侧布局-->
    <div class="layout_left_box">
      <div id="overall" class="layout_left_style">
        <div  class="layout_left_title">全局管理</div>
        <div class="layout_left_main">
        </div>
      </div>
      
      <div id="overview" class="layout_left_style">
        <div  class="layout_left_title">分局概况管理</div>
        <div class="layout_left_main">
        </div>
      </div>
      
      <div id="linkMenu" class="layout_left_style">
        <div class="layout_left_title" >链接栏目管理</div>
      </div>
      <div id="articleMenu" class="layout_left_style">
      	<div  class="layout_left_title">图文栏目管理</div>
      </div>
      <div id="videoMenu" class="layout_left_style">
        <div class="layout_left_title" >视频栏目管理</div>
      </div>
    </div>
</div>
    	<div class="welcome_wrap"></div>
</body>
</html>
