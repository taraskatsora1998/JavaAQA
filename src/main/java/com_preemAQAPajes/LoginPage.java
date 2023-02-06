package com_preemAQAPajes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder=\"Email address\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    WebElement pswdField;

    @FindBy(xpath = "//header/div/button[1]")
     WebElement loginbtn;

    @FindBy(xpath = "//button[contains(@class,'hNiaoq') and @tabindex='0']")
    WebElement loginbtntwo;

    @FindBy(className = "cky-btn-accept")
    WebElement AcceptAllCockies;

    @FindBy(xpath = "//*[contains(@class,'hSbLS')]")
    WebElement errorMsg;

    public void acceptAllCookies(){AcceptAllCockies.click();}
    public void inputLogin(String login){emailField.sendKeys(login);}
    public void inputPasswd(String pswrd){pswdField.sendKeys(pswrd);}
    public void clickLogin(){loginbtn.click();}
    public void clickLoginTwo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(loginbtntwo));
        loginbtntwo.click();}

    public String errorMessage(){
       return errorMsg.getText();
    }


}