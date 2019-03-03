package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class InvocationCount {//to execute same test case many times
	
	@Test(invocationCount=10)
	public void createUserTest() {
		System.out.println("create user test");
	}

}
