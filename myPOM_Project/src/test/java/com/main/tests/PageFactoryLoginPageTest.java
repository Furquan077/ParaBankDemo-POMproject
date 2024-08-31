package com.main.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myPOM.Base.BasePage;
import com.parabank.pages.PageFactoryLoginPage;



public class PageFactoryLoginPageTest extends BasePage {
	WebDriver driver;
	PageFactoryLoginPage page ;
	
	public PageFactoryLoginPageTest() {
		super();
	}
	
	@BeforeClass
	
	public void setup() {
		
		//LoadPropertiesFile();   //by calling properties method or creating constructor we can acquire properties
		
//		driver = new ChromeDriver();
//		driver.get("https://parabank.parasoft.com/parabank/login");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver = setupdriverandOpenURL("chrome");
		
		driver = setupdriverandOpenURL(prop.getProperty("browserName"));
		page=new PageFactoryLoginPage(driver);
	}
	
	
	@Test(priority = 0 , dataProvider = "testdata")
	public void loginTest(String username,String pass) {
		//page=new PageFactoryLoginPage(driver);
		page.setusername(username);
		page.setpassword(pass);
		page.Clicklogin();
		page.getlinks();
	}
	
	@DataProvider(name = "testdata")
	public Object[][] supplydata() {
		Object[][] data= {{prop.getProperty("username"),prop.getProperty("password")},{"admin","manager"},{"emp1","emp"}};
		return data;
	}
	
	@Test(priority = 1)
	  public void openregisterpage() {
	   
		page.Registerbtn();
		
	}
	@Test(priority = 2)
	  public void Gettitle() {
		 page.title();
	}
	@Test(priority = 3)
	  public void PrintLinks() {
	   page.getlinks();
	}
		
	@AfterClass
	
	public void teardown() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("catched exception is :" +e);
		}
	}
}
