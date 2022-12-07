package com.BuildWebApp.demo.MyFirstWeb.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "hai hello welcome";
	}
	
	@RequestMapping("/show")
	public String viewInJsp() {
		return "showView";
	}

}
