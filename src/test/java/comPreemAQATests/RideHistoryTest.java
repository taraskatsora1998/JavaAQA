package comPreemAQATests;

import com_preemAQAPajes.CalendarPage;
import com_preemAQAPajes.RideHistoryPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RideHistoryTest extends LoginTest{
    public static CalendarPage calendarPage;
    public static RideHistoryPage rideHistoryPage;

    @Test(priority = 1)
    public void rideImport() throws InterruptedException {
        calendarPage = new CalendarPage(driver);
        rideHistoryPage = new RideHistoryPage(driver);
        calendarPage.clickProfileButton();
        calendarPage.clickRideHistory();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rideHistoryPage.removeRidesIfExists());
    }
}