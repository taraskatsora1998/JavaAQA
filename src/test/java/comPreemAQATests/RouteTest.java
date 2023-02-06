package comPreemAQATests;

import com_preemAQAPajes.CalendarPage;
import com_preemAQAPajes.MyRoutesPage;
import com_preemAQAPajes.RouteDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RouteTest extends LoginTest {
    public static CalendarPage calendarPage;
    public static MyRoutesPage myRoutesPage;
    public static RouteDetailsPage routeDetailsPage;


    @Test
    public void checkAllFieldsAvailable(){
        calendarPage = new CalendarPage(driver);
        myRoutesPage = new MyRoutesPage(driver);
        routeDetailsPage = new RouteDetailsPage(driver);
        calendarPage.clickProfileButton();
        calendarPage.clickMyRoutes();
        myRoutesPage.clickOnRoute();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(routeDetailsPage.checkElementDisplaying());
        softAssert.assertAll();
    }
}
