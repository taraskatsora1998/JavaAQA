package com_preemAQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarPage {
    public WebDriver driver;


    public CalendarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//button[contains(text(),'Create a Ride')])[2]")
     WebElement createRideBtn;

    @FindBy(xpath = "//*[contains(text(),'RideWithSelenium')]/../../../../..//*[contains(@class,'sc-iBkjds bUYgGK MuiGrid-root MuiGrid-item MuiGrid-grid-xs-5')]")
    WebElement locateRideWithRoute;

    @FindBy(xpath = "//*[contains(text(),'Choose a location for weather')]")
    WebElement locateRideWithOutRoute;

    @FindBy(xpath = "//*[contains(@class,'sc-cKajLJ IdcBd')]")
    WebElement clickProfileButton;

    @FindBy(xpath = "//*[contains(text(),'Ride History')]")
    WebElement clickRideHistory;

    @FindBy(xpath = "(//*[contains(text(),'Calendar')])[1]")
    WebElement findCalenadr;

    @FindBy(xpath = "//*[contains(text(),'CancelRide')]/../../../../..//*[contains(text(),'Details')]")
    WebElement detailsCancelRide;

    @FindBy(xpath = "//*[contains(text(),'Ride has been canceled')]")
    WebElement rideCancelPopUp;

    @FindBy(xpath = "//span[text()='My Routes']")
    WebElement myRoutes;

    public void clickCreateRide(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(createRideBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", createRideBtn);
        createRideBtn.click();
    }

    public boolean locateRideWithRoute(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(locateRideWithRoute));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", createRideBtn);
        locateRideWithRoute.isDisplayed();
        return true;
    }

    public boolean locateRideWithOutRoute(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(locateRideWithOutRoute));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", locateRideWithOutRoute);
        locateRideWithOutRoute.isDisplayed();
        return true;
    }

    public void clickProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Today') and @tabindex = '-1']")));
        clickProfileButton.click();
    }

    public void clickRideHistory(){
        clickRideHistory.click();
    }
    public String findFindCalenadr(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Calendar')])[1]"))).getText();
       // return false;
    }

    public void clickDetailsCalcelRide(){
        detailsCancelRide.click();
    }

    public boolean successfullRideCancel(){
        return rideCancelPopUp.isDisplayed();
    }

    public void clickMyRoutes(){
        myRoutes.click();
    }
}