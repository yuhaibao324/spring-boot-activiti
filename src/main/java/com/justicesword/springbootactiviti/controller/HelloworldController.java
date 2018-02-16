package com.justicesword.springbootactiviti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	//欢迎界面
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Map Hello() {
		
		Map areaMap   = new HashMap();
		Map myAreaMap = new HashMap();
		
		myAreaMap.put("name", "yangli");
		myAreaMap.put("sex", "man");
		myAreaMap.put("mark", "mark");
		
		areaMap.put("error_code", "999999-0000ss-888888");
		areaMap.put("reason", "reason");
		areaMap.put("result", myAreaMap);
		
		return areaMap;
	}
	
	//欢迎界面
	@RequestMapping(value = "/world", method = RequestMethod.GET)
	public Map World() {
		
		Map areaMap = new HashMap();
		areaMap.put("hello:", "你好-world");
		areaMap.put("world", "世界-world");
		
		return areaMap;
	}
}
