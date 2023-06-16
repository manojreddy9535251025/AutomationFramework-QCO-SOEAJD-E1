package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactsLookUpImg;

	// initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateContactsLookUpImg() {
		return CreateContactsLookUpImg;
	}

	// Business Library

	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCntactsLookUpImage() {
		CreateContactsLookUpImg.click();
	}

}
