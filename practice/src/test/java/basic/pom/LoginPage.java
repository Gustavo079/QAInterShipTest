package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{
	//login
    By userLocator = By.id("userName");
    By passLocator = By.id("password");
    By signInBtnLocator = By.id("login");

    //book
    By gotoStore = By.xpath("//*[@id='gotoStore']");
    By bookUno = By.xpath("(//button[@id='addNewRecordButton'])[2]");
	String bookList = "//div[@class='action-buttons']//a";
	String  titleBook = "Git Pocket Guide";


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    //login
    public void logIn() throws InterruptedException {
        if (isDisplayed(userLocator)) {
            type("angus79", userLocator);
            type("0506Angelg@", passLocator);
            Thread.sleep(500);
            click(signInBtnLocator);
            Thread.sleep(1000);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    //addbook To your collection
    public void addBook() throws InterruptedException {
            // scroll down
            scroll();
            Thread.sleep(1000);
            click(gotoStore);
            Thread.sleep(1000);
            linkText("Git Pocket Guide");
            Thread.sleep(1000);
            scroll();
            Thread.sleep(1000);
            click(bookUno);
            aceptAlert();
            Thread.sleep(1000);
            visit("https://demoqa.com/profile");
            Thread.sleep(1000);
            verifybook(bookList, titleBook);

    }
 
}
