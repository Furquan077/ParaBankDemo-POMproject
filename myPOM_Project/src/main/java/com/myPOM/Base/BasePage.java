package com.myPOM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;

	// constructor to use in child classes
	
	public BasePage() {
		prop = new Properties();
		//String path = System.getProperty("C:\\Users\\ADMIN\\eclipse-workspace\\myPOM_Project\\src\\main\\resources\\config.properties");

		File propfile = new File("C:\\Users\\ADMIN\\git\\ParabankDemo-POMproject\\myPOM_Project\\src\\main\\resources\\config.properties");		
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	// private static String URL = "https://parabank.parasoft.com/parabank/login";

	public WebDriver setupdriverandOpenURL(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			// driver.get(URL);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			// driver.get(URL);

			break;

		case "edge":
			driver = new EdgeDriver();
			// driver.get(URL);
			break;
		default:
			System.out.println("this " + browser + "is not valid opening default browser");
			driver = new ChromeDriver();
			break;

		}
		// driver.get("https://parabank.parasoft.com/parabank/login");
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

}
