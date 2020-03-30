package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	

	//Page factory/ OR(Object Repository)
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement lbl_UserName;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	//@FindBy(xpath="//div[@id=\"navmenu\"]//a[@title='Contacts' and contains(text(),'Contacts')]")
	WebElement lnk_Contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement lnk_Deals;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement lnk_Tasks;
	
	//below constructor to Initialize Page objects
		public  HomePage() {
			//using driver below all the obj defined above in Page factory are initialized 
			//this or LoginPage.class
			PageFactory.initElements(driver, this);
		}
		
		
		public String validateHomePageTitle() {
			return driver.getTitle();
			
		}
		
		public String validateLoggedinUserName() {
			return lbl_UserName.getText();
			
			//or return boolena value T or F
			//return lbl_UserName.isDisplayed();
			
		}
		
//		public ContactsPage clickOnContactsLink() {
//			lnk_Contacts.click();
//			//return new ContactsPage();
//			
//		}
//		
		public DealsPage clickOnDealsLink() {
			lnk_Contacts.click();
			return new DealsPage();
			
		}
		
		public TasksPage clickOnTasksLink() {
			lnk_Contacts.click();
			return new TasksPage();
			
		}
		
}
