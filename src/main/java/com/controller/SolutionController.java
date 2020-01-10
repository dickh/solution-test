package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.service.DataSourceService;

/**
 * @author Kevin
 *
 */
@RestController
public class SolutionController {

	@Autowired
	DataSourceService dataSourceService;
	
	@RequestMapping("/getPossibleKeys/{key}")
	public String getPossibleKeys(@PathVariable String key) {
		
		Map<Character, String[]> sourceData = dataSourceService.getSourceData();
		
		if(null == sourceData) {
			System.out.println("sourceData --> " + sourceData);
			return null;
		}
		List<String> lss = dataSourceService.getPossibleKeys(key, sourceData);
		
		System.out.println("lss --> " + lss);
		JSONObject json = new JSONObject();
		json.put("code", lss == null ? "404" : "200");
		json.put("message", lss == null ? "data not foud" : lss);
		
		return json.toString();
	}
}
