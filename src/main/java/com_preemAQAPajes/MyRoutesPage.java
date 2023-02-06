package com_preemAQAPajes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyRoutesPage {
    private WebDriver driver;

    public MyRoutesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[contains(@class,'sc-bZkfAO hebiEM MuiTypography-root MuiTypography-inherit sc-kLLXSd gNAzcM MuiLink-root MuiLink-underlineAlways')])[1]")
    WebElement availableRoute;

    public void clickOnRoute(){
        availableRoute.click();
    }
}
