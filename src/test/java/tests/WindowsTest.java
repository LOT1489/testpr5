package com.demoqa.tests;

import com.demoqa.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends BaseTest {

    @Test
    public void shouldOpenNewTab() {
        WindowsPage page = new WindowsPage(driver, wait);
        page.open();
        String originalTitle = page.getCurrentWindowTitle();
        page.openNewTabAndVerifyTitle();
        String currentTitle = page.getCurrentWindowTitle();
        Assert.assertEquals(currentTitle, originalTitle, "Ожидалось возвращение к исходной вкладке.");
    }

    @Test
    public void shouldOpenNewWindow() {
        WindowsPage page = new WindowsPage(driver, wait);
        page.open();
        String originalTitle = page.getCurrentWindowTitle();
        page.openNewWindow();
        String currentTitle = page.getCurrentWindowTitle();
        Assert.assertEquals(currentTitle, originalTitle, "Ожидалось возвращение к исходному окну.");
    }

    @Test
    public void shouldOpenNewWindowMessage() {
        WindowsPage page = new WindowsPage(driver, wait);
        page.open();
        String originalTitle = page.getCurrentWindowTitle();
        page.openNewWindowMessage();
        String currentTitle = page.getCurrentWindowTitle();
        Assert.assertEquals(currentTitle, originalTitle, "Ожидалось возвращение к исходному окну.");
    }

    @Test
    public void shouldVerifyWindowHandling() {
        WindowsPage page = new WindowsPage(driver, wait);
        page.open();
        String originalUrl = page.getCurrentWindowUrl();
        String originalTitle = page.getCurrentWindowTitle();
        
        page.openNewTabAndVerifyTitle();
        
        Assert.assertEquals(page.getCurrentWindowUrl(), originalUrl, "Ожидалось возвращение к исходному URL.");
        Assert.assertEquals(page.getCurrentWindowTitle(), originalTitle, "Ожидалось возвращение к исходному заголовку.");
    }
}
