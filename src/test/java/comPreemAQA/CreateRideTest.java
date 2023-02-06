package comPreemAQA;

import com_preemAQA.CalendarPage;
import com_preemAQA.CreateRidePage;
import org.eclipse.sisu.inject.Soft;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateRideTest extends LoginTest{
    public CalendarPage calendarPage;
    public CreateRidePage createRidePage;


    @Test(priority = 1)
    public void checkDurationFieldEnabledWhenRouteNotSelected() {
        calendarPage = new CalendarPage(driver);
        createRidePage = new CreateRidePage(driver);
        calendarPage.clickCreateRide();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(createRidePage.clickDurationField());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void checkDurationFieldDisabledWhenRouteSelected() {
        calendarPage = new CalendarPage(driver);
        createRidePage = new CreateRidePage(driver);
        calendarPage.clickCreateRide();
        createRidePage.setSelectRoute();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(createRidePage.clickDurationField());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void checkAllRideTypesAvailable() {
        calendarPage = new CalendarPage(driver);
        createRidePage = new CreateRidePage(driver);
        calendarPage.clickCreateRide();
        createRidePage.clickRiderType();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(createRidePage.compareList2());
        softAssert.assertAll();
    }
}