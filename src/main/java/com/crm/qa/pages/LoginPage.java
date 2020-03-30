package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory/ OR(Object Repository)
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	//@FindBy(xpath="input[@name='password']")
	WebElement UPwd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signupBtn;
	
	
	
	
	//below constructor to Initialize Page objects
	public  LoginPage() {
		//using driver below all the obj defined above in Page factory are initialized 
		//this or LoginPage.class
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();	
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		UPwd.sendKeys(pwd);
		loginBtn.click();
		
		//After clicking login it navigates to HomePage so 
		//this method should returns HomePage Class object
		return new HomePage();
		
	}
	
	
	
	

}
