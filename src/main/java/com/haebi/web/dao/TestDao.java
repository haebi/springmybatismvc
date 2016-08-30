package com.haebi.web.dao;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haebi.web.model.TestModel;

@Repository("TestDao")
public class TestDao {

	@Autowired
	SqlSession sqlSession;

	public List<TestModel> getEmpList() throws SQLException{
		return sqlSession.selectList("TEST.getUserList"); // Call MyBatis query ID

	}
}