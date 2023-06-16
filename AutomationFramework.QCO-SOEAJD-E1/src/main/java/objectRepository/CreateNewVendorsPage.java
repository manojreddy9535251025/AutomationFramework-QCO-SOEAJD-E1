package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilty;

public class CreateNewVendorsPage extends WebDriverUtilty {
	
	@FindBy(xpath= "//img[@title='Create Vendor...']")
	private WebElement CreateVendorsLookUpImg;
	
	@FindBy(name = "vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(name="glacct")
	private WebElement GlAccountDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewVendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateVendorsLookUpImg() {
		return CreateVendorsLookUpImg;
	}
	
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getGlAccountDropDown() {
		return GlAccountDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//  Business Library.
	
	/**
	 * This method will click on create Vendors look up image.
	 */
	public void createNewVendor()
	{
		CreateVendorsLookUpImg.click();
	}
	
	public void vendorName(String VENDORNAME)
	{
		VendorNameEdt.sendKeys(VENDORNAME);
		
	}
	
}
