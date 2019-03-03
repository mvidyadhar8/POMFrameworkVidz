package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;

public class DealsPage extends BasePage{
	
	@FindBy(xpath = "//span[text()='Create deal']")
	WebElement dealsBtn;
	
	@FindBy(xpath = "//li//span[text() = 'Create']")
	WebElement dealsSecondBtn;
	
	@FindBy(id = "uid-ctrl-1")
	WebElement dealName;
	
	@FindBy(id = "uid-ctrl-4")
	WebElement amount;
	
	public DealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeal(String dealNameVal, String amountVal) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		System.out.println(dealNameVal+ " " +amountVal);
		wait.until(ExpectedConditions.elementToBeClickable(dealsBtn));
		dealsBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dealName));
		dealName.sendKeys(dealNameVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(amount));
		amount.sendKeys(amountVal);	
		
		wait.until(ExpectedConditions.elementToBeClickable(dealsSecondBtn));
		dealsSecondBtn.click();
	

}




}