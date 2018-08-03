package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldClass {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		
		String result = "Yo! " + name;
		
		model.addAttribute("message", result);
		
		return  "helloworld";
	}
	
	@RequestMapping(value = "/processFormVersionThree", method = RequestMethod.GET)
	public String processFormVersionThree(@RequestParam(value = "studentName") String name, 
			Model model) {
		//String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		
		String result = "Hello friend three " + name;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
