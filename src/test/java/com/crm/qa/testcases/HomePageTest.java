package com.crm.qa.testcases;


import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;





public class HomePageTest extends TestBase{
	
	
//create ref for below java class pages
	LoginPage loginPage;
	HomePage homePage;
	//ContactsPage contactsPage;
	
	//create constructor for 
		public HomePageTest() {
			//this will initialize the properties in TestBase class
			super();
		}
		
		
		//question why public
		//Test cases should be separated -- independent to each other 
		//before each test case -- launch the browser and login 
		//@test -- execute test case
		//after each test case -- close the browser
		//this is best practice if there is no link between the test cases,so browser is not exhausted/application is not crashing in between
		@BeforeClass
		public void setup() {
			intialization();
			
			//add below in @BeforeMethod as this is prerequisite to goto "Home page"
			//we need to login to application to goto home page
			//create obj for class LoginPage() so I can call login method to login
		//	loginPage = new LoginPage();
			//contactsPage = new ContactsPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));			
		}
		
	
	/*@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		System.out.println("inside loginPageTitleTest");	
		String homePageTitle = homePage.validateHomePageTitle();
		
		Assert.assertEquals(homePageTitle,"CRMPRO","Home page title is not matching");
	}*/
	
	@Test(priority=2)
	public void verifyUserName() {
		String txtUserName;
		
		TestUtil.switchToFrame("mainpanel");
		
		txtUserName = homePage.validateLoggedinUserName();
		System.out.println("txtUserName" + txtUserName);
		Assert.assertEquals(txtUserName,"  User: Demo User","Custom Error: User name is not correct");
	}
	
//	@Test(priority=3)
//	public void verifyContactsLinkTest() {
//		
//		//below line is commented if BeforeClass is used instead BeforeMethod
//		//TestUtil.switchToFrame("mainpanel");
//		contactsPage = homePage.clickOnContactsLink();
//	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("inside tear down");	
		driver.quit();
		
	}

}
