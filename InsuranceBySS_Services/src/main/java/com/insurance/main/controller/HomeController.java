package com.insurance.main.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.main.bean.ZipBean;
import com.insurance.main.logics.BusinessLogics;
import com.insurance.main.service.DataService;


@Controller

public class HomeController 
{
	@Autowired
	DataService dataService;
	Logger log=Logger.getLogger(getClass());
	@RequestMapping("/home")
	public ModelAndView openHome()
	{
		log.info("openHome() was started ");
		log.info("openHome() was stopped ");
		return new ModelAndView("home");
	}
	@RequestMapping("/index")
	public ModelAndView getIndex()
	{
		log.info("getIndex() was started ");
		log.info("getIndex() was stopped ");
		return new ModelAndView("index");
	}
	@RequestMapping(value="/customers",method=RequestMethod.POST)
	public ModelAndView validateZipCode(@RequestParam("zipCode") int zipCode , ModelMap model)
	{
		log.info("validateZipCode() started ");
		List< ZipBean> zipList=dataService.getList();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("zipCode",BusinessLogics.getBeanObject(zipList, zipCode));
		modelAndView.setViewName("customer");
		log.info("validateZipCode() ended ");
		return  modelAndView;
	}
	
	

}
