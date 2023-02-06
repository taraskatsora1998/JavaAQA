package comPreemAQATests;

import com_preemAQAPajes.CalendarPage;
import com_preemAQAPajes.CreateRidePage;
import com_preemAQAPajes.RideDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalendarTest extends LoginTest{

    public static CalendarPage calendarPage;
    public static CreateRidePage createRidePage;
    public static RideDetailsPage rideDetailsPage;


    @Test (priority = 1)
    public void testCreateRideWithRoute()  {
        calendarPage = new CalendarPage(driver);
        createRidePage = new CreateRidePage(driver);
        calendarPage.clickCreateRide();
        createRidePage.clearRideName();
        createRidePage.enterRideName("RideWithSelenium");
        createRidePage.setSelectRoute();
        createRidePage.createRideBtn();
        Assert.assertTrue(calendarPage.locateRideWithRoute());
    }

    @Test (priority = 2)
    public void testCreateRideWithOutRoute(){
        calendarPage = new CalendarPage(driver);
        calendarPage.clickCreateRide();
        createRidePage = new CreateRidePage(driver);
        createRidePage.clearRideName();
        createRidePage.enterRideName("RideWithOutRoute");
        createRidePage.createRideBtn();
        Assert.assertTrue(calendarPage.locateRideWithOutRoute());


    }

    @Test (priority = 3)
    public void testCreateRideWithOutRouteWithLocation() throws InterruptedException {
        calendarPage = new CalendarPage(driver);
        calendarPage.clickCreateRide();
        createRidePage = new CreateRidePage(driver);
        createRidePage.clickMeetUpLocation();
        createRidePage.sendSendMeetUpLocation("New York City, New York");
        createRidePage.clickAddLocation();
        createRidePage.clearRideName();
        createRidePage.enterRideName("Ride In New York");
        createRidePage.createRideBtn();
    }

    @Test (priority = 4)
    public void testCancelRide() {
        calendarPage = new CalendarPage(driver);
        calendarPage.clickCreateRide();
        createRidePage = new CreateRidePage(driver);
        rideDetailsPage = new RideDetailsPage(driver);
        createRidePage.clearRideName();
        createRidePage.enterRideName("CancelRide");
        createRidePage.setSelectRoute();
        createRidePage.createRideBtn();
        calendarPage.clickDetailsCalcelRide();
        rideDetailsPage.cancelRideClick();
        rideDetailsPage.confirmCancelRideClick();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calendarPage.successfullRideCancel());
        softAssert.assertAll();
    }
}