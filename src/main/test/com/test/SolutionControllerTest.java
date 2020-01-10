package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alibaba.fastjson.JSONObject;
import com.controller.SolutionController;

/**
 * @author Kevin
 * @description all the controller test must be extends AbstractTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SolutionControllerTest extends AbstractTest {

	@Mock
	private SolutionController solutionController;

	@Test
	public void getPossibleKeysTest4xx() throws Exception {
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/getPossibleKeys/a");

		MvcResult result = mvc.perform(mockHttpServletRequestBuilder).andReturn();
		
		JSONObject resultJson = JSONObject.parseObject(result.getResponse().getContentAsString());
		assertEquals("404", resultJson.getString("code"));
		
	}
	
	@Test
	public void getPossibleKeysTest2xx() throws Exception {
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/getPossibleKeys/123");
		
		MvcResult result = mvc.perform(mockHttpServletRequestBuilder).andReturn();
		
		JSONObject resultJson = JSONObject.parseObject(result.getResponse().getContentAsString());
		assertEquals("200", resultJson.getString("code"));
		
	}
}
