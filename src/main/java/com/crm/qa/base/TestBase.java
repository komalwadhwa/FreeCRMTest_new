package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;



public class TestBase {

	// declared below two vars as static because this is accessible all over the
	// project in CHILD CLASSES
	
	public static WebDriver driver;
	public static Properties prop;

	// check lecturer 158 and add code in below constructor and intialization()
	// method below in @BeforeSuite annotation
	// extending testbase class in each test class will make obj reference "driver" available
	public TestBase() 	{
		System.out.println("inside constructor TestBaseClass");

//			String path="//VWShopCartK//src//main//java/config1.properties";
		String path = "C:\\Users\\komal\\eclipse-workspace\\FreeCRMTest_new\\src\\main\\" 
                + "java\\com\\crm\\qa\\config\\config.properties";
//"C:\\Users\\komal\\eclipse-workspace\\VWShopCartK\\src\\main\\java\\config1.properties";

		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(path);
			// System.out.println("inside try after and print path" + path);
			
			// this will read complete file inside the memory
			prop.load(ip);
		} catch (FileNotFoundException e) {

			System.out.println("inside catch1");
			// Reporter.log(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("inside catch2");
			e.printStackTrace();
		}
		// catch (Exception E) {}

		finally {
			System.out.println("inside finally of TestBaseClass");
		}

	}
	
	public static void intialization() {
		
		String browName=prop.getProperty("browser"); //browName = "chrome";//
		if (browName.equals("chrome"))
		{
			//path variable already set
			System.setProperty("webdriver.chrome.driver", "c://Users//komal//workspace_personal//Selenium//BrowserDrivers//chromedriver.exe");
			driver  = new ChromeDriver();
		}
		else if (browName.equals("firefox"))
		 {System.setProperty("webdriver.gecko.driver", "/Users//komal//workspace_personal//Selenium//BrowserDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		System.out.println("driver launched");
		driver.get(prop.getProperty("BaseURL"));
	 
	}

}
