package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	//create reference for loginpage  as we need to 
	LoginPage loginPage;
	HomePage homePage;
	
	//create constructor for 
	public LoginPageTest() {
		//this will initialize the properties in TestBase class
		super();
	}
	
	@BeforeMethod
	//question why public
	public void setup() {
		//initialize driver, initialize chrome, launch chrome and maximize windows etc..., launch URL
		intialization();
				loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		//this method is not static so can be accessed using obj "loginPage" for the 
		// class LoginPage(), so we can access all the methods and vars of the class
		String pageTitle = loginPage.validateLoginPageTitle();
		//System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		Boolean crmImageFlag = loginPage.validateCRMImage();
		Assert.assertTrue(crmImageFlag);
		System.out.println("crmImageFlag value" + crmImageFlag);
	}
	
	@Test
	public void loginTest() {
		
		//since clicking on login button takes user to home page. 
		//below returns homePage class object
	homePage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@AfterMethod
	public void tearDown() {
	//driver.quit();
		
	}
	

}
