package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	
	@BeforeMethod //will be executed before every @Test method
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login should be executed to proceed with home page test. Hence calling login method		
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("The home page title is: " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifyHomePageHeaderTest() {
		Assert.assertTrue(homePage.verifyHomePageHeader());
		
		String homePageHeader = homePage.getHomePageHeaderText();
		System.out.println("Home page header is: " +homePageHeader);
		Assert.assertEquals(homePageHeader, Constants.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verifyContactsLinkTest() {
		homePage.navigateToContactsPage();
	}
	
	@Test(enabled=false) //this will not be executed and will be skipped
	public void verifyDealsLinkTest() {
		Assert.assertEquals(true, false);
	}
	
	
	@AfterMethod //will be executed after every @Test method
	public void tearDown() {
		driver.quit();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
