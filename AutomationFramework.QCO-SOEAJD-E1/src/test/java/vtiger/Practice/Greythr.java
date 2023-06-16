package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.WebDriverUtilty;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Greythr {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverUtilty wUtil = new WebDriverUtilty();
		
		//Step 1: launch the browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://sortiestechnologies.greythr.com/");
		
		//Step 2: Login to Application
		driver.findElement(By.name("username")).sendKeys("ST437");
		driver.findElement(By.name("password")).sendKeys("Manoj@1997");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		System.out.println("Login Successful");
		
		
		
		//logout of the Application
		driver.findElement(By.linkText("image-gt-icon-logout w-2x h-2x")).click();
		
		driver.manage().window().minimize();
		driver.quit();
		
	}

}
