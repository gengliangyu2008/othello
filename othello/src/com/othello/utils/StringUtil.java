package com.othello.utils;

public class StringUtil {

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	public static String removeSpaces(String str) {
		if( isEmpty(str) ) {
			return "";
		}
		return str.replaceAll("\\s", "");
	}
}
