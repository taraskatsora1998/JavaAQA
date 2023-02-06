package comPreemAQA;

import com_preemAQA.CalendarPage;
import com_preemAQA.LoginPage;
import org.eclipse.sisu.inject.Soft;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginTest extends PopUpHandle{
    public static LoginPage loginPage;
    public static CalendarPage calendarPage;

    @BeforeMethod(alwaysRun = true)
    public void testLogin() throws InterruptedException {
        driver.get("https://testing.gopreem.com/");
        loginPage = new LoginPage(driver);
        Thread.sleep(3000);
        loginPage.acceptAllCookies();
        Thread.sleep(1000);
        loginPage.clickLogin();
        loginPage.inputLogin("Rold1929@einrot.com");
        loginPage.inputPasswd("a123b123-1");
        loginPage.clickLoginTwo();
    }

    @Test
    public void checkUnsuccessfulLogin(){
        driver.get("https://testing.gopreem.com/");
        loginPage = new LoginPage(driver);
        loginPage.acceptAllCookies();
        loginPage.clickLogin();
        loginPage.inputLogin("testfd@gmail.com");
        loginPage.inputPasswd("a123b123");
        loginPage.clickLoginTwo();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.errorMessage(),"The email or password you entered is invalid");
        softAssert.assertAll();
    }

    @Test(groups = "groupTwo")
    public void checkSuccessfulLogin(){
        driver.get("https://testing.gopreem.com/");
        loginPage = new LoginPage(driver);
        calendarPage = new CalendarPage(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.acceptAllCookies();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.clickLogin();
        loginPage.inputLogin("test01@cuvox.de");
        loginPage.inputPasswd("a123b123-1");
        loginPage.clickLoginTwo();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calendarPage.findFindCalenadr(),"Calendar");
        softAssert.assertAll();
    }
}