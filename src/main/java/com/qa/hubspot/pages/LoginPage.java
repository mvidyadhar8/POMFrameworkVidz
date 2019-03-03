package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.Base.BasePage;

public class LoginPage extends BasePage {
	
	//1. a: define page objects (PAGE OR): Using page factory pattern
	
	@FindBy(id = "username")                                 //helps us to define and design our locators
	WebElement emailId;
	
	@FindBy(id = "password")                                 
	WebElement password;
	
	@FindBy(id = "loginBtn")                                 
	WebElement loginButton;

	@FindBy(linkText = "Sign up")
	WebElement signUpLink;
	
	//1. b: Constructor of page class and initialize elements with driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //this means current class. Can also be written as LoginPage.class
	}
	
	//2. Methods / Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifySignUpLink() {
		return signUpLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver); //Page Chaining. After clicking login button, user will be directed to home page, so we are creating a reference of home page
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
