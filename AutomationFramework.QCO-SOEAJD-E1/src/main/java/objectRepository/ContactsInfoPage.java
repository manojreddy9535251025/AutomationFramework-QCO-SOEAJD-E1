package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;

	//Intialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Busines Library.
	/**
	 * This method will get the header text.
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}
	
}
