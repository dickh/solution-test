package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Solution {

	public static void main(String[] args) {
		
		Map<Character, String[]> keyMaps = getSourceData();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("please enter 0-9: ");
			String str = scanner.next();
			List<String> lss = getPossibleKeys(str, keyMaps);
			System.out.println(lss);
		}
	}
	
	public static Map<Character, String[]> getSourceData() {
		Map<Character, String[]> keyMaps = new HashMap<Character, String[]>();
		keyMaps.put('0', new String[] {"0"});
		keyMaps.put('1', new String[] {"1"});
		keyMaps.put('2', new String[] {"a", "b", "c"});
		keyMaps.put('3', new String[] {"d", "e", "f"});
		keyMaps.put('4', new String[] {"g", "h", "i"});
		keyMaps.put('5', new String[] {"j", "k", "l"});
		keyMaps.put('6', new String[] {"m", "n", "o"});
		keyMaps.put('7', new String[] {"p", "q", "r", "s"});
		keyMaps.put('8', new String[] {"t", "u", "v" });
		keyMaps.put('9', new String[] {"w", "x", "y", "z"});
		return keyMaps;
	}
	
	public static ArrayList<String> getPossibleKeys(String inputStr, Map<Character, String[]> sourceData) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if(StringUtils.isEmpty(inputStr)) {
			System.out.println("illegal input, please try again");
			return null;
		}
		if(!isNumeric(inputStr)) {
			System.out.println("illegal input, please enter 0-9");
			return null;
		}
		// input length is less than 2
		if(inputStr.length() < 2) {
			if("0".equals(inputStr) || "1".equals(inputStr)) {
				result.add(inputStr);
			} else {
				// handle 2, 3, 4, 5, 6, 7, 8, 9
				String []str = sourceData.get(inputStr.toCharArray()[0]);
				for(int i=0; i<str.length; i++) {
					result.add(str[i]);
				}
			}
			return result;
		}
		// input length is more than 1
		String str = inputStr.substring(0, inputStr.length() - 1);
		ArrayList<String> sonList = getPossibleKeys(str,sourceData);
		String[] words = sourceData.get(inputStr.charAt(inputStr.length() - 1));
		for (int i = 0; i < words.length; i++) {
			for (Iterator<String> iterator = sonList.iterator(); iterator.hasNext();) {
				String sonStr = iterator.next();
				result.add(sonStr + words[i]);
			}
		}
		return result;
	}
	
	public static boolean isNumeric(String inputStr){
		if(StringUtils.isEmpty(inputStr)) {
			return false;
		}
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(inputStr).matches();   
	}
}
