package com.otm.util;

import java.util.Random;

public class KeyGenerator {

	public static String getStandardRandomAlphabetic(){
		return getRandomAlphabetic(36);
	}

	public static String getRandomAlphabetic(int charCount){
		int leftLimit = 65; // letter 'A'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(charCount);
		for (int i = 0; i < charCount; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

}
