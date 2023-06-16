package genericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to all webdriver actions.
 * @author Manoj
 *
 */

public class WebDriverUtilty {
	
	/**
	 * This method will maximize the window.
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will Minimize the window.
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for page to load for 20 seconds.
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for 20 seconds for a element to be visible.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will wait for 20 seconds for a element to be click able.
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop down by index.
	 * @param element
	 * @param index
	 */
	
	/**  This is the best example of method over Loading  */
	
	public void handleDropDown(WebElement element, int  index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by value.
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element , String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop down by visible text.
	 * @param visibletext
	 * @param element
	 */
	
	public void handleDropDown(String visibleText , WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will perform mouse hover action.
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		 Actions act = new Actions(driver);
		 act.moveToElement(element).perform();
	}
	
	/**
	 * This method will right click anywhere on web page.
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions  act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click on particular web element.
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will  drag and drop from src element to target element.
	 * @param driver
	 * @param srcElement
	 * @param targetElemet
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElemet)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElemet).perform();
	}
	
	/**
	 * This method will  drag and drop from src element to target element offsets.
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, int x, int y)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}
	
	/**
	 * This  method will perform double click randomly on web page.
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This Method will perform double click on particular web page.
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver , WebElement element) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will handle frame by index.
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or ID.
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame by web element.
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver , WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the control from child frame to immediate parent.
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control from child frame to deafult parent.
	 * @param driver
	 */
	
	public void switchTodefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will accept the alert pop-up.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop-up.
	 * @param driver
	 */
	public void dissmisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text from alert pop-up. 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will scroll down for 500 units.
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0 , 500)", "");
	}
	
	/**
	 * This method will scroll until a particular element.
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy( 0 ,"+ y + ",)", element);
		
	}
	
	/**
	 * This method will take screenshot and save it in screenshot folder.
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots//"+screenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //used for extent report
		
	}
	
	/**
	 * This method will switch thw windows based on window title.
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		// Step 1: Capture all the window IDs.
		Set<String> winIDs = driver.getWindowHandles();
		
		// Step 2: Navigate to each window.
		for (String winID : winIDs) 
		{
			// Step 3: Capture the title of each window
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			// Step 4: Compare the Title.
			if (actTitle.contains(partialWindowTitle)) {
				break;
			}	
		}	
	}
	
	
	
	

}
