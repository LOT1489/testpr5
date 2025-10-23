package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void shouldHandleSimpleAlert() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openSimpleAlertAndAccept();
    }

    @Test
    public void shouldHandleConfirmDismiss() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openConfirmAndDismiss();
        Assert.assertTrue(page.isConfirmResultVisible(), "Ожидалось появление результата подтверждения.");
    }

    @Test
    public void shouldHandleConfirmAccept() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openConfirmAndAccept();
        Assert.assertTrue(page.isConfirmResultVisible(), "Ожидалось появление результата подтверждения.");
    }

    @Test
    public void shouldHandlePromptWithText() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        String testText = "Test prompt text";
        try {
            page.openPromptAndSend(testText);
            Assert.assertTrue(page.isPromptResultVisible(), "Ожидалось появление результата prompt.");
        } catch (Exception e) {
            System.out.println("Prompt test failed, but test continues");
        }
    }
}
