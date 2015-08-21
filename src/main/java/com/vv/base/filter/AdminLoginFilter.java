package com.vv.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PC后台登陆拦截器
 */
public class AdminLoginFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("text/html; charset=UTF-8");
		String currentURL = req.getRequestURI();
		if (currentURL.indexOf("login") > -1){
			chain.doFilter(request, response);
			return;
		}
		String loginBean = (String)req.getSession().getAttribute("username");
		if (null!=loginBean) {
			// Session中含有用户名
			chain.doFilter(request, response);
		} else {
			// Session中没有用户名，将请求转发到错误页面或者登录页面
			/*判断是不是ajax请求 ajax请求 返回700*/
			if(req.getHeader("x-requested-with") != null && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				resp.setStatus(700);
				return;
			}
			//请求重定向
			String domainUrl = req.getContextPath();
			resp.sendRedirect(domainUrl+"/toLogin.mvv");
		}


	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
