package com.zhanglf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanglf.bo.StudentBo;
import com.zhanglf.cache.ICacheService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource(name = ICacheService.SERVICEID)
	private ICacheService cacheService;

	@RequestMapping("/info")
	@ResponseBody
	public List getAllStudentInfo() {
		List<StudentBo> list = new ArrayList<>();
		list = cacheService.getAllStudent();
		return list;
	}

	@RequestMapping("/byId")
	@ResponseBody
	public Integer getAllStudentInfoById(HttpServletRequest request) {
		List<StudentBo> list = new ArrayList<>();
		StudentBo bo = cacheService.getStudentById(Integer.valueOf(request
				.getParameter("id")));

		return bo.getAge();
	}

}
