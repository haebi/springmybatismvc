package com.haebi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.haebi.web.service.TestService;


@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	static Gson gson = new Gson();
	
	@RequestMapping(value = "/web", method = RequestMethod.GET)
	public ModelAndView testPage()
	{
		ModelAndView mav = new ModelAndView();
		
		String message = "This sample message from controller~!!";
		String message2 = "This is a second message test";
		
		// set sample content
		mav.addObject("hello", message);
		mav.addObject("welcome", message2);
				
		// set view page name
		mav.setViewName("test");
		
		return mav;
	}
	
	@RequestMapping(value = "/weblist", method = RequestMethod.GET)
	public ModelAndView testPageList()
	{
		ModelAndView mav = new ModelAndView();
		
		// Call services
		mav.addObject("list", testService.getEmpDetail());
		mav.addObject("list2", testService.getEmpDetail());
		// ... if you need more
		
		mav.setViewName("testlist");
		
		return mav;
	}
	
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public JsonObject testJson()
    {
    	JsonObject resultObj = new JsonObject();
    	
    	resultObj.addProperty("groupId", "GROUP_ID");
    	resultObj.addProperty("serviceId", "SERVICE_ID");
    	resultObj.addProperty("resultMessage", "RESULT_MESSAGE");
		
		return resultObj;
    }
    
    @ResponseBody
    @RequestMapping(value = "/jsonlist", method = RequestMethod.GET)
    public JsonObject testJsonList()
    {
    	return testService.getEmpDetailJson();
    }

}
