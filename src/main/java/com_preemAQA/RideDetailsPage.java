package com_preemAQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RideDetailsPage {
    public WebDriver driver;

    public RideDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//button[contains(.,'Cancel Ride')]")
    WebElement calcelRideBtn;

    @FindBy (xpath = "//button[contains(.,'Yes, cancel')]")
    WebElement confirmCancelRide;


    public void cancelRideClick(){
        calcelRideBtn.click();
    }

    public void confirmCancelRideClick(){
        confirmCancelRide.click();
    }
}
