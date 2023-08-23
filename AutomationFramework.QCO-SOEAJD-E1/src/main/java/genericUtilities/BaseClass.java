package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG.
 * @author Manoj
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public  ExcelFileUtility eUtil =  new ExcelFileUtility();
	public JavaUtility jUtil =  new JavaUtility();
	public WebDriverUtilty wUtil  = new WebDriverUtilty();
	
	public WebDriver driver = null;
	
   public static WebDriver sDriver;
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("======DB Connection Successful======");
	}
	
	// @Parameters("browser")   /*Cross-BrowserExecution */
	// @BeforeTest             /* Distributed-Parallel Execution.*/
    @BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		 String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome"))  //Runtime Polymorphism
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"====== Browser Launched ======");
		}
		else 
		{
			System.out.println("====== Invalid Browser Name ======");
		}
		
		sDriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("====== Login to App Successful ======");
		
	}
	
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void  amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("===== Logout of App Successful ======");
	}	
	
	
	// @AfterTest   /*Distributed Parallel Execution.*/
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("===== Browser Closed ======");
	}
		
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("DB Connection Closed");
	}

}
