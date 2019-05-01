package com.insurance.main.controller;

import org.apache.log4j.Logger;
import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*@RequestMapping("/")*/
public class IntializeClass {
private Logger log=Logger.getLogger(getClass());
@RequestMapping(value="/", method= RequestMethod.GET)
public String init(HttpServletRequest request,HttpServletResponse response)
{
	log.info("init() method started");
	log.info("init() method ended");
	return "index";
	
}

}
