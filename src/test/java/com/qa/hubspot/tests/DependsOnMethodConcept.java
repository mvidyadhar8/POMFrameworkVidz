package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test(priority=1)	
	public void loginTest() {
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(priority=2, dependsOnMethods="loginTest")//will be executed only if login test is passed
	public void clickOnContactsTest() {
		System.out.println("clickOnContactsTest");

	}

}
