package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

// needs to use ElementHandler to wait for the webpage, sendKeys and click
public class Login extends ElementHandler {

    // element By locators
    By usernameBy = By.xpath("//input[@data-testid=\"login-email-component\"]");
    By passwordBy = By.xpath("//input[@data-testid=\"login-password-component\"]");
    By loginButtonBy = By.xpath("//button[@data-testid=\"login-button\"]");

    // uses driver from parent class ElementHandler
    public Login(WebDriver driver) {
        super(driver);
    }

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