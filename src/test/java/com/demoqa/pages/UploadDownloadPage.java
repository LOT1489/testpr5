package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDownloadPage extends BasePage {
    private final By upload = By.id("uploadFile");
    private final By uploaded = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/upload-download");
    }

    public void uploadFile(String absolutePath) {
        el(upload).sendKeys(absolutePath);
    }

    public String uploadedPath() {
        return el(uploaded).getText();
    }

    public boolean isUploadedPathVisible() {
        return el(uploaded).isDisplayed();
    }
}
