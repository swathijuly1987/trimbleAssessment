package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class MyStorePageObject {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(linkText = "Sign in")
	WebElement signInLink;

	public MyStorePageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Click on Sign In Link
	public void clickSignIn() {
		signInLink.click();
	}

	// Get the title of MyStore Page
	public String getLoginTitle() {
		return driver.getTitle();
	}

}
