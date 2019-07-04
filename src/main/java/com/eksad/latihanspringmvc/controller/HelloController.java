package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(){
		return "Hello World";
	}
	
	@RequestMapping("/myName")
	@ResponseBody 
	public String myName(@RequestParam String myName){ // untuk menampung parameter
		return "Hello " + myName;
	}
	
	@RequestMapping("/namaSaya/{myName}")
	@ResponseBody
	public String namaSaya(@PathVariable String myName){
		return "Hello " + myName;
		
	}
	
	@RequestMapping("/toGoogle")
	@ResponseBody
	public String toGoogle(){
		return "<a href='http://google.com'> Klik disini menuju google </a>"
				+ "<br><a href='http://youtube.com' target='_blank'> Klik disini menuju youtube</a>";	
	}
	
	
	
	
	
	
}
