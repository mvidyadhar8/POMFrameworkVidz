package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.TestUtil;

public class DealsPageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public DealsPage dealsPage;
	
	@BeforeMethod //will be executed before every @Test method
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login should be executed to proceed with home page test. Hence calling login method		
		dealsPage = homePage.navigateToDealsPage();
	}
	
	@DataProvider(name = "getDealsTestData")
	public Object[][] getDealsTestData(){
		Object dealsData [][] = TestUtil.getDealsTestdata(Constants.DEALS_SHEET_NAME);
		return dealsData;
	}
	
	@Test(dataProvider = "getDealsTestData")
	public void createNewDealsTest(String dealname, String amount) {
		dealsPage.createNewDeal(dealname, amount);
	}
	
	@AfterMethod //will be executed after every @Test method
	public void tearDown() {
		driver.quit();
	}	
	
	
	

}
