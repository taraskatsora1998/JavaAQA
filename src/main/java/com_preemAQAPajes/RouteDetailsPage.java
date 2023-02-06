package com_preemAQAPajes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RouteDetailsPage {
    private WebDriver driver;

    public RouteDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(@class,'sc-ejVUYw bxNDVx')]")
    WebElement weatherBlock;

    @FindBy(xpath = "//span[@class='sc-fVLGaz hspDtl MuiSlider-colorPrimary MuiSlider-sizeMedium MuiSlider-root']")
    WebElement weatherSlider;

    @FindBy(xpath = "//*[contains(text(),'Photos')]")
    WebElement photoBtn;

    public boolean checkElementDisplaying(){
         boolean elementDisplayed = false;
        if(weatherBlock.isDisplayed() && weatherBlock.isDisplayed() && photoBtn.isDisplayed()){
            elementDisplayed = true;
        }
        return elementDisplayed;
    }
}
