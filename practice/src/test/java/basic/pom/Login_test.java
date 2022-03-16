package basic.pom;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login_test {

    static WebDriver driver;

    LoginPage logInPage;

    @Before
    public void setUp() throws Exception {
        logInPage = new LoginPage(driver);
        driver = logInPage.chromeDriverConnection();
        logInPage.browser("https://demoqa.com/login");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        logInPage.logIn();
        logInPage.addBook();
        Thread.sleep(2000);

    }
}
