package com.qa.hubspot.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("test1 method");
	}
	
	@Test
	public void test2() {
		System.out.println("test2 method");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	/*
	 * beforeSuite
beforeTest
beforeClass
beforeMethod
test1 method
afterMethod
beforeMethod
test2 method
afterMethod
afterClass
afterTest
PASSED: test1
PASSED: test2
	 */
	
	
	
	
	
	

}
