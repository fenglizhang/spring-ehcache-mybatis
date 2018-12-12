package com.zhanglf.controller;

import java.util.Iterator;
import java.util.List;

import org.ehcache.Cache;
import org.ehcache.Cache.Entry;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanglf.bo.StudentBo;

@Controller
@RequestMapping("/studentEhcache")
public class TestEhcacheStudentController {

	@RequestMapping("/info")
	@ResponseBody
	public List getAllStudentInfo() {
		List<StudentBo> sb = null;
		// 使用指定配置文件创建:
		// java代码：
		// CacheManager manager = CacheManager.create("src/config/ehcache.xml");
		// 从classpath中找寻配置文件并创建:
		// java代码：
		// URL url = getClass().getResource("/anothername.xml");
		// CacheManager manager = CacheManager.create(url);
		CacheManager cacheManager = (CacheManager) CacheManagerBuilder
				.newCacheManagerBuilder()
				.withCache(
						"studentCache",
						CacheConfigurationBuilder.newCacheConfigurationBuilder(
								Integer.class, List.class,
								ResourcePoolsBuilder.heap(10))).build();
		cacheManager.init();
		//我的理解是数据结构在缓存中是这样的：[Object实体,Object实体,...]  结构：List<StudentBo>
		//getCache(配置文件中起的缓存容器名,key的type,value的type)
		Cache<Integer, List> cache = cacheManager.getCache("studentCache",Integer.class, List.class);
		StudentBo s = (StudentBo) cache.get(0);
		return sb;
	}

}
