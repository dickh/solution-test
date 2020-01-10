package com.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.utils.NumberUtils;

import mockit.integration.junit4.JMockit;

/**
 * @author Kevin
 *
 */
@RunWith(JMockit.class)
@SpringBootTest
public class NumberUtilsTest {

	@Test
	public void dataTest() {
		NumberUtils dataUtils = new NumberUtils();
		assertFalse(dataUtils.isNumeric("aa"));
		assertFalse(dataUtils.isNumeric("aa2"));
		assertTrue(dataUtils.isNumeric("2222"));
	}
}
