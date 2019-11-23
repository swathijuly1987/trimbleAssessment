package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginMyStorePageObject;
import pages.MyAccountPageObject;
import pages.MyStorePageObject;

public class VerifyUserRegistration {

	String driverPath = "C:\\Users\\sasubramaniyan\\jar_files\\geckodriver.exe";

	WebDriver driver;

	MyStorePageObject myStorePage;

	LoginMyStorePageObject loginPage;
	MyAccountPageObject myAccountPageObject;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

	/**
	 * 
	 * This test go to http://automationpractice.com/
	 * 
	 * Verify home page title as 'My Store'
	 * 
	 * Sign In to application
	 * 
	 * Verify the login page using Page title as "Login - My Store"
	 */

	@Test(priority = 0)
	public void test_Home_Page_Appear_Correct() {
		try {

			// Create Login Page object
			myStorePage = new MyStorePageObject(driver);

			// Verify login page title
			String homePageTitle = myStorePage.getLoginTitle();
			if (homePageTitle.contains("My Store")) {
				Assert.assertTrue(true, "Verify home page.");
			} else {
				Assert.assertFalse(true, homePageTitle + " page is loaded.");
			}
			myStorePage.clickSignIn();

			// go the next page
			loginPage = new LoginMyStorePageObject(driver);

			String loginPageTitle = loginPage.getLoginTitle();
			// Verify login page

			if (loginPageTitle.contains("Login - My Store")) {
				Assert.assertTrue(true, "Verify Login Page Title.");
			} else {
				Assert.assertFalse(true, loginPageTitle + " page is loaded instead of Login Page.");
			}
			// register as new user to application

			loginPage.registerToMyStore("mgr13456@test.com");
			// go the next page
			myAccountPageObject = new MyAccountPageObject(driver);

			String myAccountPageTitle = loginPage.getLoginTitle();
			// Verify My Account page
			if (myAccountPageTitle.contains("My account - My Store")) {
				Assert.assertTrue(true, "Verify user is able to register successfully");

			} else {
				Assert.assertFalse(true, myAccountPageTitle + " page is loaded. Registration page is not loaded.");
			}
		}

		catch (Exception e) {

		}
	}

	@AfterMethod
	public void shutdown() {

		driver.close();
	}

}
