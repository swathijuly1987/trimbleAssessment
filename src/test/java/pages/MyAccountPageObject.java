package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageObject {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(linkText = "Sign out")
	WebElement signOutLink;

	@FindBy(className = "account")
	WebElement accountNameLink;

	@FindBy(xpath = "//a[@title='Women']")
	WebElement womenLink;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Get the title of Login Page
	public String getMyAccountPageTitle() {
		return driver.getTitle();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void verifyMyAccountPage() {

		
	}
	
	
	public void clickWomenLink() {
		womenLink.click();
	}
}
