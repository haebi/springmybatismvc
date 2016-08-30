package com.haebi.web.service;

import java.util.ArrayList;
import java.util.List;

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

	// web
	public List<TestModel> getEmpDetail(){
		
		List<TestModel> model = new ArrayList<TestModel>();
				
		try {
			
			model = testDao.getEmpList();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return model;
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
			String resultStr2 = gson.toJson(testDao.getEmpList());
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
