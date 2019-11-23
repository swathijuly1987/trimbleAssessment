package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WomenMyStorePageObject {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
	WebElement fadedShortSleeveLink;

	@FindBy(id = "add_to_cart")
	WebElement addToCartButton;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement checkOutButton;

	@FindBy(xpath = "//a[@title='Continue shopping']")
	WebElement proccedToCheckOutButton;
	
	public WomenMyStorePageObject(WebDriver driver) {
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

	// Get the title of Women - My StorePage
	public String getLoginTitle() {
		return driver.getTitle();
	}
	
	public void clickFadedShortSleeveLink() {
		try {
		if(fadedShortSleeveLink.isDisplayed()) {
		fadedShortSleeveLink.click();
		}
		}
		catch(Exception e) {
			
		}
	}
	
	
	public void clickFadedShortSleeveButtonByMouseOver() {
		try {
			Actions actions = new Actions(driver);
		if(fadedShortSleeveLink.isDisplayed()) {
			actions.moveToElement(fadedShortSleeveLink).perform();
			fadedShortSleeveLink.click();
		}
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	public void clickAddToCartButtonkLink() {
		try {
			if(addToCartButton.isDisplayed())
		addToCartButton.click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void clickCheckOutButtonLink() {
		try {
			if(checkOutButton.isDisplayed())
			checkOutButton.click();
		}catch(Exception e){
			
		}
		
	}
	
	public void clickproccedToCheckOutButton() {
		try {
			if(proccedToCheckOutButton.isDisplayed())
				proccedToCheckOutButton.click();
		}catch(Exception e){
			
		}
		
	}


}
