package com.vv.web.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vv.service.AppNewsService;

@Controller
@RequestMapping("/manage")
public class IndexManageController {
	
	@Autowired
	private AppNewsService appNewsService;
	
	
	@ResponseBody
	@RequestMapping("/index.mvv")
	public Object index(Integer pageNo,Integer number){
		long start = System.currentTimeMillis();
		Object o = appNewsService.getList(pageNo,number); 
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		return o;
	}
	
	@ResponseBody
	@RequestMapping("/index1.mvv")
	public Object index1(Integer pageNo,Integer number){
		long start = System.currentTimeMillis();
		Object o = appNewsService.getList2(pageNo,number); 
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		return o;
	}
	
	@ResponseBody
	@RequestMapping("/index2.mvv")
	public Object index2(Integer pageNo,Integer number){
		long start = System.currentTimeMillis();
		Object o = appNewsService.getList2(pageNo,number); 
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		return o;
	}
}
