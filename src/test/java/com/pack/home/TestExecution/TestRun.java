package com.pack.home.TestExecution;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pack.home.Libraries.DriverLaunch;
import com.pack.home.Libraries.LibraryForGenericFunction;

public class TestRun {
	DriverLaunch Dlib = new DriverLaunch();
	public static WebDriver driver;	
	LibraryForGenericFunction lib = null;

	@BeforeTest
	public void executing() throws InterruptedException, IOException {
		driver = Dlib.openBrowser("chrome");
		lib = new LibraryForGenericFunction(driver);
		// Application link will be opened
		driver.get("http://69.176.98.99:9356/admin/");
	}
	
	@Test(priority = 1, description="Performs an successful login and checks the dashboard url (passes)")
    public void login() throws InterruptedException, IOException {
        lib.jsSendKeysForID("loginform-email", "loginform-email", "login", "ID");
        lib.jsSendKeysForID("loginform-password", "loginform-password", "login", "ID");
        Assert.assertTrue(lib.waitAndClickForID("login", "login", "ID"));
        Thread.sleep(2000);
        //Assert.assertEquals(lib.getCurrentUrl(), "");                    
    }

	/*@Test(priority = 2, description="Navigate to forgot Password page")
	public void passwdlink() throws InterruptedException, IOException {
		lib.waitAndClickForID("passwdlink", "login", "class");
	}
	
	@Test(priority = 3, description="Enter mail address page ")
	public void emaillink() throws InterruptedException, IOException {
		lib.jsSendKeysForID("emaillink", "abcd123@gmail.com", "login", "ID");
		
		Assert.assertTrue(lib.waitAndClickForID("emaillink2", "login", "name"));
		Thread.sleep(2000);
		//Assert.assertEquals(lib.getCurrentUrl(), "http://marcus.oneeight.co.in/zeno/dashboard");					
	}*/
	
		
	@AfterTest()
	public void afterMethod() throws IOException {
		driver.quit();		
	}	
}
