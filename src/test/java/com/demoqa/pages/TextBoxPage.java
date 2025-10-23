package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends com.demoqa.pages.BasePage {
    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By output = By.id("output");
    private final By emailField = By.cssSelector("#userEmail");

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fill(String name, String email, String curr, String perm) {
        el(userName).sendKeys(name);
        el(userEmail).sendKeys(email);
        el(currentAddress).sendKeys(curr);
        el(permanentAddress).sendKeys(perm);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el(submit));
        click(submit);
    }

    public boolean isOutputVisible() {
        return el(output).isDisplayed();
    }

    public String emailValidationClass() {
        return el(emailField).getAttribute("class");
    }

    public String getOutputText() {
        return el(output).getText();
    }
}
