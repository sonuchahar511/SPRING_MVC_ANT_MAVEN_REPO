package com.chahar.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController extends AbstractPageController {
	
	@RequestMapping(value="/hello1")
	public String hello1Page(ModelMap model) {
		LOG.info(" /hello1  called");
		
		LOG.trace("Trace Message!");
		LOG.debug("Debug Message!");
		LOG.info("Info Message!");
		LOG.warn("Warn Message!");
		LOG.error("Error Message!");
		LOG.fatal("Fatal Message!");
		
		model.addAttribute("hello1","hello1 model attribute");
		
		return "hello";
	}
	
	@RequestMapping(value="/hello2",method= {RequestMethod.GET,RequestMethod.POST})
	public String hello2Page(ModelMap model) {
		LOG.info(" /hello2 + GET/POST called");
		
		model.addAttribute("hello2","hello2 greeting message");
		
		return "hello";
	}
	
	
}
