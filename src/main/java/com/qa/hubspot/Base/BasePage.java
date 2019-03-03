package com.qa.hubspot.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {

	public WebDriver driver; // public web driver reference, so that it can be used anywhere
	public Properties prop; // Properties reference to be used to fetch properties
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>(); // creates driver copy in memory so
																					// that multiple test cases can be
																					// accessed

	public WebDriver initialize_driver() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Executables\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies(); // deletes all the cache and cookies
		// driver.manage().window().fullscreen(); //manage the window in full screen mode
		driver.manage().window().maximize();
		tdriver.set(driver); //set will create local copy for the driver
		return getDriver(); 

	}

	public static synchronized WebDriver getDriver() { //get will get the local copy of driver
		return tdriver.get();
	}

	public Properties initialize_Properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\Naveen_Selenium\\JanPOMSeries\\src\\main\\java\\com\\qa\\"
					+ "hubspot\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) tdriver.get()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		}catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
