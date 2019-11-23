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
import pages.OrderMyStorePage;
import pages.WomenMyStorePageObject;

public class VerifyOrderFlow {

	String driverPath = "C:\\Users\\sasubramaniyan\\jar_files\\geckodriver.exe";

	WebDriver driver;

	MyStorePageObject myStorePage;

	LoginMyStorePageObject loginPage;
	MyAccountPageObject myAccountPageObject;
	OrderMyStorePage orderMyStorePage;
	WomenMyStorePageObject womenMyStorePageObject;

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

	@Test
	public void verifyOderDetails() {
		try {

			myStorePage = new MyStorePageObject(driver);// Create Login Page object

			String homePageTitle = myStorePage.getLoginTitle();// Verify login page title
			Assert.assertTrue(homePageTitle.contains("My Store"));// verify Page title

			myStorePage.clickSignIn();

			loginPage = new LoginMyStorePageObject(driver);// go the next page
			String loginPageTitle = loginPage.getLoginTitle();
			Assert.assertTrue(loginPageTitle.contains("Login - My Store"));// Verify login page

			loginPage.loginToAccount("mgr123@test.com", "India@123"); // register as new user to application
			myAccountPageObject = new MyAccountPageObject(driver);// go the next page
			String myAccountPageTitle = myAccountPageObject.getMyAccountPageTitle();

			Assert.assertTrue(myAccountPageTitle.contains("My account - My Store"),
					"Verify user is able to login successfully.");// Verify
			// My
			// Account
			// page

			myAccountPageObject.clickWomenLink(); // Click on Women Link
			womenMyStorePageObject = new WomenMyStorePageObject(driver);
			womenMyStorePageObject.clickFadedShortSleeveButtonByMouseOver();
			womenMyStorePageObject.clickAddToCartButtonkLink();
			womenMyStorePageObject.clickCheckOutButtonLink();
			womenMyStorePageObject.clickCheckOutButtonLink();
			womenMyStorePageObject.clickCheckOutButtonLink();

			orderMyStorePage = new OrderMyStorePage(driver);
			orderMyStorePage.clickagreeCheckBox();
			orderMyStorePage.clickcheckOutButton();
			orderMyStorePage.clickPayByWireBankLink();
			orderMyStorePage.clickconfirmMyOrderButton();
			if (driver.getPageSource().contains("Your order on My Store is complete.")) {
				Assert.assertTrue(myAccountPageTitle.contains("My account - My Store"),
						"User is able to place the order successfully, Successmessage is displayed.");

			} else {
				Assert.assertFalse(true, "User is unable to place the order");

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
