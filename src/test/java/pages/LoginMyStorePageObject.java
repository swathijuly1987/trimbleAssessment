package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginMyStorePageObject {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(id = "customer_firstname")
	WebElement customerFirstName;

	@FindBy(id = "customer_lastname")
	WebElement customerLastName;

	@FindBy(id = "email")
	WebElement customerEmail;

	@FindBy(id = "passwd")
	WebElement customerPassword;

	@FindBy(id = "address1")
	WebElement customerAddress;

	@FindBy(id = "city")
	WebElement customerCity;

	@FindBy(id = "id_state")
	WebElement customerState;

	@FindBy(id = "postcode")
	WebElement customerPostCode;

	@FindBy(id = "id_country")
	WebElement customerCountry;

	@FindBy(id = "phone_mobile")
	WebElement customerPhoneMobile;

	@FindBy(id = "submitAccount")
	WebElement customerRegister;

	@FindBy(id = "email_create")
	WebElement userEmailAddressTextbox;

	@FindBy(id = "SubmitCreate")
	WebElement createAnAccountButton;

	@FindBy(name = "btnLogin")
	WebElement register;

	@FindBy(xpath = "//a[@title='Women']")
	WebElement womenLink;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;	
	
	public LoginMyStorePageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

//	//Set string in textbox
	public void setText(String inputSting, WebElement locator) {
		if (locator.isDisplayed()) {
			locator.sendKeys(inputSting);
		}
	}

	public void selectItemByIndex(String inputSting, WebElement locator) {
		Select drpValue = new Select(locator);
		drpValue.selectByIndex(1);
	}

	// Click on Register button
	public void clickRegister() {
		customerRegister.click();
	}

	// Click on Create an Account button
	public void clickCreateAnAccount() {
		createAnAccountButton.click();
	}

	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	// Get the title of Login - My StorePage
	public String getLoginTitle() {
		return driver.getTitle();
	}

	
	public void registerToMyStore(String emailAddress) {
		this.setText(emailAddress, userEmailAddressTextbox);
		this.clickCreateAnAccount();

		if(customerPhoneMobile.isDisplayed()) {
		this.setText("firstname", customerFirstName);
		this.setText("lastname", customerLastName);
		this.setText("India@123", customerPassword);
		this.setText("Addres", customerAddress);
		this.setText("city", customerCity);
		this.selectItemByIndex("state", customerState);
		this.setText("11111", customerPostCode);
		this.selectItemByIndex("country", customerCountry);
		this.setText("10000000", customerPhoneMobile);

		// Click Login button
		this.clickRegister();
		}
		else
		{
			Assert.assertFalse(true, "Registration page is not loaded");
		}

	}
	
	
	public void loginToAccount(String emailAddress,String pwd) {
		this.setText(emailAddress, customerEmail);
		this.setText(pwd, customerPassword);
		// Click Login button
		this.clickSignInButton();

	}
}
