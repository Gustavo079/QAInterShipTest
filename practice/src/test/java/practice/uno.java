package practice;

//import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class uno {

	private WebDriver driver;
	
	By userlocator = By.id("userName");
	By passlocator = By.id("password");
	By signlocator = By.id("login");
	By HoPelocator = By.id("username-value");
	
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/selenium_driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");
	}
	
	// this methods help to close the test 
	@After
	public void tearDown() 
	{
		/*driver.close();
		driver.quit();*/
	}

	
	@Test
	public void FillElementsInput() throws InterruptedException
	{
		if(driver.findElement(userlocator).isDisplayed()) {
			driver.findElement(userlocator).sendKeys("angus79");
			driver.findElement(passlocator).sendKeys("0506Angelg@");
			Thread.sleep(1000);
			driver.findElement(signlocator).click();
			Thread.sleep(1000);
			
			//assertEquals("angus79",driver.findElement(passlocator).getText());
		} /*else{
			System.out.println("username textbox wasn´t present");
		}*/
	}

}
