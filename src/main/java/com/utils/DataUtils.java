package com.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * 
 * @author Kevin
 *
 */
public class DataUtils {

	/**
	 * @param inputStr: when inputStr is number, then return true
	 * @return
	 */
	public static boolean isNumeric(String inputStr){
		if(StringUtils.isEmpty(inputStr)) {
			return false;
		}
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(inputStr).matches();   
	}
}
