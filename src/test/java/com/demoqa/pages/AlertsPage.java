package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {
    private final By alertBtn = By.id("alertButton");
    private final By confirmBtn = By.id("confirmButton");
    private final By promptBtn = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void openSimpleAlertAndAccept() {
        click(alertBtn);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void openConfirmAndDismiss() {
        click(confirmBtn);
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void openConfirmAndAccept() {
        click(confirmBtn);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void openPromptAndSend(String text) {
        click(promptBtn);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public String getConfirmResult() {
        return el(confirmResult).getText();
    }

    public String getPromptResult() {
        return el(promptResult).getText();
    }

    public boolean isConfirmResultVisible() {
        return el(confirmResult).isDisplayed();
    }

    public boolean isPromptResultVisible() {
        return el(promptResult).isDisplayed();
    }
}
