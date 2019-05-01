package com.insurance.main.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.insurance.main.bean.ZipBean;
import com.insurance.main.json.JsonResponse;
import com.insurance.main.service.DataService;

@Controller
@RequestMapping("/HomeAjax")
public class HomeAjax {
	@Autowired
	DataService dataService;
	Logger log = Logger.getLogger(getClass());

	@RequestMapping(value = "/getZips", method = RequestMethod.GET)
	public @ResponseBody
	void getTags(@RequestParam("term") String zipCode,HttpServletRequest request,HttpServletResponse response) throws IOException {
		log.info("getTags() started");
		List<String> listString=dataService.getZipList(zipCode);
			String result = new Gson().toJson(listString);
			
			 response.getWriter().write(result);
			 
		}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public @ResponseBody
	void getZipData(@RequestParam("term") String zipCode,HttpServletRequest request,HttpServletResponse response) throws IOException {
		log.info("getData() started");
		JsonResponse jsonResponse=new JsonResponse();
		ZipBean zipBean=new ZipBean();
		List<ZipBean> listZipBean=dataService.getZipData(zipCode);
		Iterator<ZipBean> iterator=listZipBean.iterator();
		while(iterator.hasNext())
		{
			jsonResponse.setStatus("SUCCESS");
			zipBean=(ZipBean)iterator.next();
			jsonResponse.setResultObject(zipBean);
		}
			
			String result = new Gson().toJson(jsonResponse);
			 response.getWriter().write(result);
			
		}
			
	
}
