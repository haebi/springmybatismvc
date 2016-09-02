package com.haebi.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// log
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// json
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.haebi.web.dao.TestDao;
import com.haebi.web.model.TestModel;


@Service("TestService")
public class TestService {

	private static final Logger log = LoggerFactory.getLogger(TestService.class);
	
	static Gson gson = new Gson();
	
	@Autowired
	private TestDao testDao;

	// web - sample with Model Class
	public List<TestModel> getEmpDetail(){
		
		List<TestModel> model = new ArrayList<TestModel>();
				
		try {
			
			model = testDao.getEmpList();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return model;
	}
	
	// web - sample without Model Class (Using Java.util.Map as Model)
	public List<Map<String, String>> getFruitList(){
		
		List<Map<String, String>> model = new ArrayList<Map<String, String>>();
				
		try {
			
			model = testDao.getFruitList();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return model;
	}
	
	// web - Add User Information
	public List<Map<String, String>> addUserInfo(TestModel param){
							
		try {
			
				testDao.addUserInfo(param);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}

	// json
	public JsonObject getEmpDetailJson(){
		JsonObject resultObj = new JsonObject();
		
		try {
			
			// List<> -> String
			String resultStr = gson.toJson(testDao.getEmpList());
			// string -> JsonObject
			JsonElement strToJsonObj = gson.fromJson(resultStr, JsonElement.class);
			
			// List<> -> String #2
			String resultStr2 = gson.toJson(testDao.getFruitList());
			// string -> JsonObject #2
			JsonElement strToJsonObj2 = gson.fromJson(resultStr2, JsonElement.class);
			
			// ... #n if you need more ...
			
			// Add additional property
			resultObj.addProperty("group", "GROUP_ID");
			resultObj.addProperty("service", "SERVICE_ID");
			resultObj.add("data", strToJsonObj);
			resultObj.add("data2", strToJsonObj2);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return resultObj;
	}

}
