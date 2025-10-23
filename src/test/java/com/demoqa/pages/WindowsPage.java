package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsPage extends com.demoqa.pages.BasePage {
    private final By newTabBtn = By.id("tabButton");
    private final By newWindowBtn = By.id("windowButton");
    private final By newWindowMessageBtn = By.id("messageWindowButton");

    public WindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/browser-windows");
    }

    public void openNewTabAndVerifyTitle() {
        String original = driver.getWindowHandle();
        click(newTabBtn);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(original);
    }

    public void openNewWindow() {
        String original = driver.getWindowHandle();
        click(newWindowBtn);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(original);
    }

    public void openNewWindowMessage() {
        String original = driver.getWindowHandle();
        click(newWindowMessageBtn);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(original);
    }

    public String getCurrentWindowTitle() {
        return driver.getTitle();
    }

    public String getCurrentWindowUrl() {
        return driver.getCurrentUrl();
    }
}
