package com.codingbat.warmup1;

/**
 * 
 * @author AH0663232 Problem statement: Given an int n, return true if it is
 *         within 10 of 100 or 200. Note: Math.abs(num) computes the absolute
 *         value of a number.
 * 
 *         nearHundred(93) → true nearHundred(90) → true nearHundred(89) → false
 */
public class NearHundred {

	public static void main(String[] args) {
		NearHundred nearHundred = new NearHundred();
		System.out.println(nearHundred.nearHunder(93));
		System.out.println(nearHundred.nearHunder(90));
		System.out.println(nearHundred.nearHunder(89));
	}
	
	boolean nearHunder(int n){
		
		if(Math.abs(n - 100) <= 10 || Math.abs(200 - n) <= 10)
			return true;
		return false;
	}
}
