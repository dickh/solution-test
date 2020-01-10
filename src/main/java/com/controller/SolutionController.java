package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.filter.LoggerFilter;
import com.service.DataSourceService;

/**
 * @author Kevin
 *
 */
@RestController
public class SolutionController {

	private final Logger logger = LoggerFactory.getLogger(SolutionController.class);
	@Autowired
	DataSourceService dataSourceService;
	
	@RequestMapping("/getPossibleKeys/{key}")
	public String getPossibleKeys(@PathVariable String key) {
		
		Map<Character, String[]> sourceData = dataSourceService.getSourceData();
		logger.info("sourceData --> " + sourceData);
		
		if(null == sourceData) {
			return null;
		}
		List<String> lss = dataSourceService.getPossibleKeys(key, sourceData);
		logger.info("lss --> " + lss);
		
		JSONObject json = new JSONObject();
		json.put("code", lss == null ? "404" : "200");
		json.put("message", lss == null ? "data not foud" : lss);
		
		return json.toString();
	}
}
