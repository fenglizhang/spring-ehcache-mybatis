package com.zhanglf.cache;

import java.util.List;

import com.zhanglf.bo.StudentBo;

public interface ICacheService {
	final String SERVICEID="ICacheService";
	public List<StudentBo> getAllStudent();
	
	public StudentBo getStudentById(int id);

}
