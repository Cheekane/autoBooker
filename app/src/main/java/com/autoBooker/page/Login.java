package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

// needs to use ElementHandler to wait for the webpage, sendKeys and click
public class Login extends ElementHandler {

    // uses driver from parent class ElementHandler
    public Login(WebDriver driver) {
        super(driver);
    }

    // element By locators
    By usernameBy = By.id("txtUsername");
    By passwordBy = By.id("txtPassword");
    By loginButtonBy = By.xpath("//button[@data-testid=\"login-button\"]");

    // navi to login page and maximize window
    public void navTo() {
        driver.manage().window().maximize();
        driver.get("https://city-of-london-golf-courses.book.teeitup.golf/login");
    }

    public void enterUsername(String username) {
        sendKey(usernameBy, username);
    }

    public void enterPassword(String password) {
        sendKey(passwordBy, password);
    }

    public void clickLogin() {
        click(loginButtonBy);
    }
}