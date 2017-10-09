package com.codingbat.warmup1;

/**
 * 
 * @author AH0663232 Problem statement: Given a string, return a new string
 *         where "not " has been added to the front. However, if the string
 *         already begins with "not", return the string unchanged. Note: use
 *         .equals() to compare 2 strings.
 * 
 *         notString("candy") → "not candy" notString("x") → "not x"
 *         notString("not bad") → "not bad"
 */
public class NotString {
	
	public static void main(String[] args) {
		
		NotString notString = new NotString();
		System.out.println(notString.notString("candy"));
		System.out.println(notString.notString("x"));
		System.out.println(notString.notString("not bad"));
		System.out.println(notString.notString(""));
	}

	private String notString(String str){
		
		if(str.startsWith("not"))
			return str;
		else return "not " + str;
	}
}
