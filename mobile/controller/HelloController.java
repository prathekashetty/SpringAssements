package com.wolken.mvc.controller;


	import org.apache.log4j.Logger;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;

	
	@Controller
	public class HelloController {
		Logger logger=Logger.getLogger(HelloController.class);
		@RequestMapping("/hello")
		String PrintHello() {
			logger.info("controller is calling");
			
			return "welcome.jsp";
			
		}
		
	}

