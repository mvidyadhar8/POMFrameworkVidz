package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPage;

public class LoginTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	//Test Methods / Test Cases / Test Classes
	
	//test case 1:
	//pre condition: open browser, enter url
	//test steps -- test case : loginTest -- un/pwd/loin button
	//validations -- ac vs exp
	//post step: close the browser
	
	//test case 2:
	//pre condition: open browser, enter url
	//test steps -- test case : check signup link on page
	//validations -- ac vs exp
	//post step: close the browser
	
	@BeforeMethod //will be executed before every @Test method
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);		
	}
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);		
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.VerifySignUpLink());
	}
	
	@Test(priority=3)
	public void loginCorrectCredentialsTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod //will be executed after every @Test method
	public void tearDown() {
		driver.quit();
	}	

}
