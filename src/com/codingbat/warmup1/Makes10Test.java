package com.codingbat.warmup1;

import junit.framework.TestCase;

public class Makes10Test extends TestCase{

	Makes10 makes10 = new Makes10();
	
	
	public void testMakes10(){
		
		assertEquals(makes10.makes10(9, 10), true);
		assertEquals(makes10.makes10(9, 9), false);
		assertEquals(makes10.makes10(1, 9), true);
		assertEquals(makes10.makes10(10, 1), true);
		assertEquals(makes10.makes10(10, 10), true);
		assertEquals(makes10.makes10(8, 2), true);
		assertEquals(makes10.makes10(8, 3), false);
		assertEquals(makes10.makes10(10, 42), true);
		assertEquals(makes10.makes10(12, -2), true);
	}
}
