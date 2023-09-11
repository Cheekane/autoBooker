package com.autoBooker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHandler1 {
    protected WebDriver driver;

    public ElementHandler1(WebDriver driver) {
        this.driver = driver;
    }

    protected void sendKey(By by, String value) {
        getElement(by).sendKeys(value);
    }

    public void click(By by) {
        getElement(by).click();
    }

    public int countElements(By by) {
        List<WebElement> elements = getElements(by);
        return elements.size();
    }

    /*
    gets the element being searched for with By, adds 10 seconds of an explicit wait until element is found
     */
    protected WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    protected List<WebElement> getElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
}
