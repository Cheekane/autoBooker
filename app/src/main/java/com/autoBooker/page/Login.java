package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
needs to use ElementHandler to wait for the webpage, sendKeys and click
 */
public class Login extends ElementHandler {

    /*
    uses driver from parent class ElementHandler
     */
    public Login(WebDriver driver) {
        super(driver);
    }

    // element By locators
    By usernameBy = By.id("txtUsername");
    By passwordBy = By.id("txtPassword");
    By loginButtonBy = By.xpath("//button[@data-testid='login-button'");

    /*
    navigates to the login page
     */
    public void navTo() {
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
