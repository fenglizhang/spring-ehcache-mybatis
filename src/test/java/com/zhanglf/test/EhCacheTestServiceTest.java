package com.zhanglf.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.zhanglf.cache.ICacheService;

public class EhCacheTestServiceTest extends SpringTestCase {
		@Resource
	    private ICacheService cacheService;

	    @Test  
	    public void getTimestampTest() throws InterruptedException{  
	      cacheService.getAllStudent();
	      Thread.sleep(1500);
	      cacheService.getStudentById(2);
	    } 
}
