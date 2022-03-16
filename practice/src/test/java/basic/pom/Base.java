package basic.pom;



import org.junit.Assert;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.JavascriptExecutor;

public class Base {

	private WebDriver driver;
	public static WebDriverWait objExplicitWait;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/selenium_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	//Find the browser that we are using
	public void browser(String url) {
		driver.get(url);
	}

	// This help to scroll down
	public void scroll() {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	
	//
	public void linkText(final String locator) {
		WebElement objElement = Login_test.driver.findElement(By.linkText(locator));
		objElement.click();
	}
	
	public void visit(String url) {
        driver.get(url);
    }
	
	//Accept the Alert and use switchTo To accept the alert
	public void aceptAlert() {
		WebDriverWait wait = new WebDriverWait(Login_test.driver, 3000);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = Login_test.driver.switchTo().alert();
		alert.accept();
	}
	
	//check the book was added
	public void verifybook(String bookList, String titleBook) {
		List<WebElement> lsBook = driver.findElements(By.xpath(bookList));
		if(lsBook.size() > 0) {
			for (WebElement book: lsBook) {
				if(book.getText().equalsIgnoreCase(titleBook)) {
					System.out.println("The Book: "+ titleBook +"Was found");

				}
			}
		}else {
			System.out.println("The Book was not found");
			Assert.fail();
		}
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}