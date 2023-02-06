package com_preemAQAPajes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CreateRidePage {
    public WebDriver driver;

    public CreateRidePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[contains(@class,'PrivateSwitchBase-root sc-bjuIDw dLkCOg')])[2]")
    WebElement selectRoute;


    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement createRideBtn;

    @FindBy(xpath = "//*[contains(@name,'description')]")
    WebElement writeDescription;

    @FindBy(xpath = "//input[contains(@name,'name')]")
    WebElement selectRideName;

    @FindBy(xpath = "//*[contains(text(),'Meet Up Location')]")
    WebElement clickMeetUpLocation;

    @FindBy(xpath = "//*[contains(@class,'mapboxgl-ctrl-geocoder--input')]")
    WebElement sendMeetUpLocation;

    @FindBy(xpath = "New York City, New York")
    WebElement selectFromDropDown;

    @FindBy(xpath = "//*[contains(text(),'Add Location') and @tabindex='0']")
    WebElement clickAddLocation;

    @FindBy(xpath = "//*[contains(@class,'mapboxgl-ctrl-geocoder--input')]")
    WebElement searchLocationField;

    @FindBy(xpath = "(//input[contains(@class,' MuiInputBase-inputAdornedEnd')])[4]")
    WebElement fieldDuration;

    @FindBy(xpath = "//div[@id='mui-component-select-rideType']")
    WebElement riderType;

    public void setSelectRoute() {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectRoute).click().build().perform();
    }

    public void createRideBtn() {
        createRideBtn.click();
    }

    public void clickOnDescription(String Description) {
        writeDescription.sendKeys(Description);
    }

    public void clearRideName() {
        selectRideName.clear();
    }

    public void clearSearchLocationField() {
        searchLocationField.clear();
    }

    public void enterRideName(String rideName) {
        selectRideName.sendKeys(rideName);
    }

    public void clickMeetUpLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickMeetUpLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void sendSendMeetUpLocation(String meetUpLocation) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div[1]/div/b")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", b);
        //   sendMeetUpLocation.click();
        sendMeetUpLocation.clear();
        sendMeetUpLocation.sendKeys(meetUpLocation);
        Thread.sleep(5000);
        sendMeetUpLocation.sendKeys(Keys.ENTER);
    }

    public void selectFromDropDown() {
        selectFromDropDown.click();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public void clickAddLocation() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (int i = 0; i < 2; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(clickAddLocation));
            clickAddLocation.click();
        }
    }

    public boolean clickDurationField() {
        return fieldDuration.isEnabled();
    }

    public void clickRiderType() {
        riderType.click();
    }

    public boolean compareList2() {
        boolean isNotEqual = true;
        List<String> rideType = Arrays.asList("Adaptive", "Bike Packing", "Cyclocross", "Gravel", "MTB", "Recumbent", "Road", "Touring", "Track", "Triathlon", "Urban", "Other");
        List<WebElement> riderTypeList = driver.findElements(By.xpath("//*[@role='option']"));
            for (int i = 0; i < rideType.size(); i++) {
                if (!riderTypeList.get(i).getText().equals(rideType.get(i))) {
                    isNotEqual = false;
                    System.out.println(riderTypeList.get(i).getText());
                }else if (rideType.size() != riderTypeList.size()) {
                    isNotEqual = false;
                }
        }
        return  isNotEqual;
    }
}