package com.vv.web.show;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("/index.fvv")
	public String index(){
		return "/show/index";
	}
}
