package com.codingbat.warmup1;

/**
 * 
 * @author AH0663232 Problem statement: Given an int n, return the absolute
 *         difference between n and 21, except return double the absolute
 *         difference if n is over 21.
 * 
 *         diff21(19) → 2 diff21(10) → 11 diff21(21) → 0
 */
public class Diff21 {

	public static void main(String[] args) {
		
		Diff21 diff21 = new Diff21();
		System.out.println(diff21.diff21(2));
		System.out.println(diff21.diff21(11));
		System.out.println(diff21.diff21(0));
		System.out.println(diff21.diff21(21));
		System.out.println(diff21.diff21(22));
		System.out.println(diff21.diff21(20));
		System.out.println(diff21.diff21(-1));
	}
	
	private int diff21(int n){
		
		int diff = 21 - n;
		int absdiff = diff >= 0 ? diff : -diff;
		
		if(n > 21)
			return absdiff * 2;
		
		return absdiff;
	}
}

