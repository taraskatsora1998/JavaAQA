package comPreemAQATests;

import com_preemAQAPajes.CalendarPage;
import com_preemAQAPajes.LoginPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginTest extends PopUpHandle{
    public static LoginPage loginPage;
    public static CalendarPage calendarPage;

    public void loginMethod() throws InterruptedException {
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

    @Test(priority = 1)
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

    @Test(priority = 2)
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
        loginPage.inputLogin("Rold1929@einrot.com");
        loginPage.inputPasswd("a123b123-1");
        loginPage.clickLoginTwo();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calendarPage.findFindCalenadr(),"Calendar");
        softAssert.assertAll();
    }
}