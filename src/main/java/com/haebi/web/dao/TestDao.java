package com.haebi.web.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haebi.web.model.TestModel;

@Repository("TestDao")
public class TestDao {

	@Autowired
	SqlSession sqlSession;

	// sample with Model Class
	public List<TestModel> getEmpList() throws SQLException{
		return sqlSession.selectList("TEST.getUserList"); // Call MyBatis query ID
	}
	
	// sample without Model Class (Using Java.util.Map as Model)
	public List<Map<String, String>> getFruitList() throws SQLException{
		return sqlSession.selectList("TEST.getFruitList");
	}
	
}