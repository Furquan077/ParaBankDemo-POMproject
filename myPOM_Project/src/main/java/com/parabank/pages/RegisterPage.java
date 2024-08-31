package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myPOM.Base.BasePage;

public class RegisterPage extends BasePage {

	WebDriver driver;

	// constructor
	public RegisterPage(WebDriver driver) {
			this.driver=driver;

		PageFactory.initElements(driver, this);
	}

	// locator
	@FindBy(xpath = "//a[text()='Register']") 
	WebElement register;
	
	@FindBy(id = "customer.firstName")
	WebElement firstname;

	@FindBy(id = "customer.lastName")
	WebElement lastname;

	@FindBy(id = "customer.address.street")
	WebElement address;

	@FindBy(id = "customer.address.city")
	WebElement city;

	@FindBy(id = "customer.address.state")
	WebElement state;

	@FindBy(id = "customer.address.zipCode")
	WebElement zcode;

	@FindBy(id = "customer.phoneNumber")
	WebElement phone;

	@FindBy(id = "customer.ssn")
	WebElement ssn;

	@FindBy(id = "customer.username")
	WebElement username1;

	@FindBy(id = "customer.password")
	WebElement password1;

	@FindBy(id = "repeatedPassword")
	WebElement confirm;
	
	@FindBy(xpath = "//input[@class='button']//parent::td")
	WebElement registerbtn;
	
	// action
	public void Registerbtn(){
		register.click();
	}
	
	public void setfirstname(String fname) {

		firstname.sendKeys(fname);
	}

	public void setlastname(String lname) {

		lastname.sendKeys(lname);
	}

	public void setaddress(String add) {

		address.sendKeys(add);
	}

	public void setcity(String cityname) {

		city.sendKeys(cityname);
	}

	public void setstate(String statename) {

		state.sendKeys(statename);
	}

	public void setzipcode(String code) {

		zcode.sendKeys(code);
	}

	public void setphone(String number) {

		phone.sendKeys(number);
	}

	public void setssn(String ssn1) {

		ssn.sendKeys(ssn1);
	}

	public void setusername(String username) {

		username1.sendKeys(username);
	}

	public void setpassword(String password) {

		password1.sendKeys(password);
	}

	public void setrepeatpassword(String confirmpass) {

		confirm.sendKeys(confirmpass);
	}
	
	public void clickregister() {
		
		registerbtn.click();
	}

	public  void Title() {
		System.out.println("Page Title is :" +driver.getTitle());
	}
	
	public  void URL() {
		System.out.println("URL is :" +driver.getCurrentUrl());
	}
}
