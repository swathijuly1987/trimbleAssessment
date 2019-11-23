package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderMyStorePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;

	@FindBy(id = "cgv")
	WebElement agreeCheckBox;

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByWireBankLink;

	@FindBy(xpath = "//a[@title='Other payment methods']")
	WebElement otherPaymentMethods;

	@FindBy(xpath = "//a[@title='I confirm my order']")
	WebElement confirmMyOrderButton;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement checkOutButton;

//	Your order on My Store is complete.

	public OrderMyStorePage(WebDriver driver) {
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
	public void clickOtherPaymentsMethodButton() {
		try {
			if(otherPaymentMethods.isDisplayed())
				otherPaymentMethods.click();
		}catch(Exception e){
			
		}
	}

	// Click on Create an Account button
	public void clickPayByWireBankLink() {
		try {
			if(payByWireBankLink.isDisplayed())
				payByWireBankLink.click();
		}catch(Exception e){
			
		}
	}
	
	public void clickcheckOutButton() {
		try {
			if(checkOutButton.isDisplayed())
				checkOutButton.click();
		}catch(Exception e){
			
		}
	}
	
	// Click on Agree Checkbox
	public void clickagreeCheckBox() {
		try {
			if(agreeCheckBox.isDisplayed())
				agreeCheckBox.click();
		}catch(Exception e){
			
		}
	}

	// Click on confirm my order
	public void clickconfirmMyOrderButton() {
		try {
			if(confirmMyOrderButton.isDisplayed())
				confirmMyOrderButton.click();
		}catch(Exception e){
			
		}
	}

	// Get the title of Order - My StorePage
	public String getLoginTitle() {
		
		return driver.getTitle();
	}

	
	public void clickproccedToCheckOutButton() {
		try {
			if(checkOutButton.isDisplayed())
				checkOutButton.click();
		}catch(Exception e){
			
		}
	}
}

