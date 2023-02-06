package comPreemAQATests;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class PopUpHandle {

protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void popUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "/Users/quart_alex/Desktop/com_preemAQA/chromedrivers/chromedriver");
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((HasAuthentication) driver).register(UsernameAndPassword.of("tester", "Grw_?3U3"));

    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}