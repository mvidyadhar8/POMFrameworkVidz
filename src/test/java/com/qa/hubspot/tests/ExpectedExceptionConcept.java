package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	@Test(expectedExceptions = ArithmeticException.class)
	public void sumTest() {
		int a = 10;
		int b = 20;
		int c= a+b;
		System.out.println(c);
		System.out.println(c/0); //this fail case will be ignored and test case will pass
		System.out.println(c+10);
	}
}
