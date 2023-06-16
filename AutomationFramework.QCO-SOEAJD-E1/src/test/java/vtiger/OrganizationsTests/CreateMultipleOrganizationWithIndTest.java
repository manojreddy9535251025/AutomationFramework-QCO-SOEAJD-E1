package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOraganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;


public class CreateMultipleOrganizationWithIndTest extends BaseClass {

	@Test(dataProvider = "getData")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException {
		
		String ORGNAME = ORG + jUtil.getRandomNumber();

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		CreateNewOraganizationPage cnop = new CreateNewOraganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();

		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Test Script Passed");
		} else {
			System.out.println("FAIL");
		}

	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("DataProviderOrg");

	}
}
