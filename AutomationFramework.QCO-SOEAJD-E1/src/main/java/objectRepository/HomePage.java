package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilty;

public class HomePage extends WebDriverUtilty{ //Rule 1: Create a class
	
	//Rule 2: Identify the element using annotations.
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Vendors")
	private WebElement VendorsLnk;
	

	//Rule 3: Create a Constructor to intialize.
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Rule 4: Provide getters to Access.
    // Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	
	public WebElement getMoreLnk() {
		return MoreLnk;
	}
	
	public WebElement getVendorsLnk() {
		return VendorsLnk;
	}
	
	
	//Business Library
	/**
	 * This method will click on Organization link.
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationsLnk.click();
	}
	/**
	 * This method will click on Contacts link.
	 */
	
	public void clickonContactsLink()
	{
		ContactsLnk.click();
	}
	/**
	 * This method will click  on Products link.
	 */
	
	public void clickOnProductsLink()
	{
		ProductsLnk.click();
	}
	
	/**
	 * This method will logout of the Application.
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	
	public void clickOnVendorsLink(WebDriver driver)
	{
		mouseHoverAction(driver, MoreLnk);
		VendorsLnk.click();
	}
	
}
 