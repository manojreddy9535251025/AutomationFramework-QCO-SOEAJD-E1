package vtiger.OrganizationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOraganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrgWithIndustryTest extends BaseClass
{	
		@Test(groups="SmokeSuite")
		public void createOrgWithIndTest() throws IOException
		{
			
			String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
			String INDUSTRY =  eUtil.readDataFromExcel("Organizations", 4, 3);
			
			// Step 3: Click on Organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			Reporter.log("Clicked on Organizations Link",true);

			// Step 4: Click on Create Org Look Up Image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();
			Reporter.log("Clicked on Create Org Look Up Image",true);
			
			//Assert.fail();
			// Step 5: Create Organization with mandatory fields
			CreateNewOraganizationPage cnop = new CreateNewOraganizationPage(driver);
			cnop.createNewOrganization(ORGNAME, INDUSTRY);
			Reporter.log("Organization Created With Industry",true);

			// Step 8: Validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String orgHeader = oip.getHeader();
			Assert.assertTrue(orgHeader.contains(ORGNAME));

		}		
		
		@Test
		public void demo()
		{
			System.out.println("This is Demo");
		}
}
