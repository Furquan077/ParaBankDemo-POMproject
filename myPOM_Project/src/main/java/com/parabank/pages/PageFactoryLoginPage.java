package com.parabank.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPage {

	WebDriver driver;
	
	//constructor
	
	public PageFactoryLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locator
	
	@FindBy(xpath = "//input[@name='username']") WebElement username;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//input[@class='button']") WebElement login_btn;
	@FindBy(xpath = "//a[text()='Register']") WebElement register;
	
	@FindBy(tagName = "a") List<WebElement> Link;
	
	//Action
	
	public void setusername(String user) {
		username.sendKeys(user);
	}
	public void setpassword(String pass) {
		password.sendKeys(pass);
	}
	public void Clicklogin(){
		login_btn.click();
	}
	public void Registerbtn(){
		register.click();
	}
	public void title() {
		System.out.println(driver.getTitle());
	}
	public void getlinks() {
		System.out.println(Link.toString());
	}
}
