package com.autoBooker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHandler {

    protected WebDriver driver;

    public ElementHandler(WebDriver driver) {
        this.driver = driver;
    }

    // gets element and waits for presenceOfElementLocated for 10 seconds
    protected WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    protected List<WebElement> getElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
    }

    // waits for visibility of element located before throwing exception
    protected void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void sendKey(By by, String value) {
        getElement(by).sendKeys(value);
    }

    protected void click(By by) {
        getElement(by).click();
    }

    protected int countElements(By by) {
        List<WebElement> elements = getElements(by);
        return elements.size();
    }
}
