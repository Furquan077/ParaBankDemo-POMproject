package com.main.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myPOM.Base.BasePage;
import com.parabank.pages.RegisterPage;

public class RegisterPageTest extends BasePage {

	WebDriver driver;
	RegisterPage rp;
	
	public RegisterPageTest() {
		super();
	}

	@BeforeClass
	
	public void setup() {
		
		driver = setupdriverandOpenURL(prop.getProperty("browserName"));
		rp=new RegisterPage(driver);
		
		//driver = setupdriverandOpenURL("chrome");
		System.out.println("started chrome driver");
	}

	@Test(priority = 0)
	public void newregistertest() {
		rp = new RegisterPage(driver);
		rp.Registerbtn();
		rp.setfirstname("Atom");
		rp.setlastname("Zues");
		rp.setaddress("crystal Tower");
		rp.setcity("Mumbai");
		rp.setstate("Maharashtra");
		rp.setzipcode("0380");
		rp.setphone("9414812554");
		rp.setssn("9413544");
	}

	@Test(priority = 1)
	public void setuser() {

		rp.setusername("Atom.zues");
		rp.setpassword("Atom.zues@321");
		rp.setrepeatpassword("Atom.zues@321");
		rp.clickregister();
	}

	@Test(priority = 2)
	public void URLtest() {

		rp.URL();
		Assert.assertEquals("https://parabank.parasoft.com/parabank/register.htm", "https://parabank.parasoft.com/parabank/register.htm");
	}

	@Test(priority = 3, dependsOnMethods = "URLtest")
	public void Titletest() {

		rp.Title();
		Assert.assertEquals("ParaBank | Register for Free Online Account Access", "ParaBank | Register for Free Online Account Access");
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