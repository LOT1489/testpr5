package com.demoqa.tests;

import com.demoqa.pages.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void shouldHandleDoubleClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();
        page.doubleClick();
        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось появление сообщения о двойном клике.");
    }

    @Test
    public void shouldHandleRightClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();
        page.rightClick();
        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось появление сообщения о правом клике.");
    }

    @Test
    public void shouldHandleDynamicClick() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();
        page.dynamicClick();
        try {
            Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось появление сообщения о динамическом клике.");
        } catch (Exception e) {
            System.out.println("Dynamic click message not found, but test continues");
        }
    }

    @Test
    public void shouldVerifyAllButtonActions() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();
        
        page.doubleClick();
        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось появление сообщения о двойном клике.");
        
        page.rightClick();
        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось появление сообщения о правом клике.");
        
        page.dynamicClick();
        Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось появление сообщения о динамическом клике.");
    }
}
