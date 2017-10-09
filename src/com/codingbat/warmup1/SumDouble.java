package com.codingbat.warmup1;

/**
 * 
 * @author AH0663232 Problem statement: Given two int values, return their sum.
 *         Unless the two values are the same, then return double their sum.
 * 
 *         sumDouble(1, 2) → 3 sumDouble(3, 2) → 5 sumDouble(2, 2) → 8
 */
public class SumDouble {

	public static void main(String[] args) {

		SumDouble sumDouble = new SumDouble();
		System.out.println(sumDouble.sumDouble(3, 2));
	}

	public int sumDouble(int a, int b) {

		if (a != b)
			return a + b;
		return 2 * (a + b);
	}
}
