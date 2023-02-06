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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RideHistoryPage {
    public WebDriver driver;

    public RideHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='btn-upload']")
    WebElement clickBrowseBtn;

    @FindBy(xpath = "//*[contains(@class,'sc-kkKunT')]")
    WebElement detectUploadedRide;

    @FindBy(xpath = "//button[contains(.,'Upload')]")
    WebElement clickUploadBtn;

    @FindBy(xpath = "//*[contains(., 'Retry')]")
    WebElement clickRetryBtn;

    @FindBy(xpath = "//input[contains(@type,'checkbox')]")
    WebElement clickCheckboxBtn;

    @FindBy(xpath = "//*[@id='action']")
    WebElement clickArrowBtn;

    @FindBy(xpath = "//*[contains(@role,'menuitem')]")
    WebElement clickRemoveBtn;

    @FindBy(xpath = "//strong")
    WebElement checkForActivities;

    @FindBy(xpath = "//*[contains(text(),'Uploading in progress. Current status: ')]")
    WebElement successfullUpload;

    public void clickBrowseBtn() {
        clickBrowseBtn.sendKeys("/Users/quart_alex/Desktop/fit2.zip");
    }

    public boolean removeRidesIfExists() throws InterruptedException {
        boolean verifyUpload = true;
        String activities = checkForActivities.getText();
        if (!activities.equals("9")) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            clickBrowseBtn.sendKeys("/Users/quart_alex/Desktop/fit.zip");

            clickUploadBtn.click();
            if(driver.findElement(By.xpath("//*[contains(text(), 'File Upload Error')]")).isDisplayed()) {
                Thread.sleep(2000);
                clickRetryBtn.click();
            }
            //clickRetryBtn.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Uploading in progress. Current status: ')]")));
            if (!successfullUpload.isDisplayed()) {
                verifyUpload = false;
            }
        } else {
            clickCheckboxBtn.click();
            clickArrowBtn.click();
            clickRemoveBtn.click();
            Thread.sleep(2000);
            clickBrowseBtn.sendKeys("/Users/quart_alex/Desktop/fit.zip");
            clickUploadBtn.click();
            Thread.sleep(2000);
                while (clickRetryBtn.isDisplayed()){
                    clickRetryBtn.click();
                    Thread.sleep(2000);
                }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Uploading in progress. Current status: ')]")));
            if (!successfullUpload.isDisplayed()) {
                verifyUpload = false;
            }
        }
        return verifyUpload;
    }


    public void setClickUploadBtn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement uploadBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Upload')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadBtn);
        clickUploadBtn.click();
        clickRetryBtn.click();
        clickRetryBtn.click();
        clickRetryBtn.click();
    }

    public boolean countNumOfRides() {

        List<WebElement> webElements = driver.findElements(By.xpath("//*[contains(@class,'sc-kNjMHG juWwWd MuiTableRow-root sc-kkKunT iiHSnk')]"));
        int count = 0;
        for (int i = 0; i < webElements.size(); i++) {
            count++;
        }
        if (count <= 9) {
            return true;
        } else
            return false;
    }
}
