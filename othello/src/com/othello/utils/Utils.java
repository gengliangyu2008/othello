package com.othello.utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Utils {
	
	public static <T> T getOneRandomElement(Set<T> set) {
		if( set == null || set.isEmpty() ) {
			return null;
		}
		
		Random random = new Random();
		return new ArrayList<T>(set).get(random.nextInt(set.size()));
	}
}
