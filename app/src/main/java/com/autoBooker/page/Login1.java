package com.autoBooker.page;


import com.autoBooker.ElementHandler1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login1 extends ElementHandler1 {
    public Login1(WebDriver driver) {
        super(driver);
    }

    By usernameBy = By.id("txtUsername");
    By passwordBy = By.id("txtPassword");
    By loginButtonBy = By.className("MuiButton-label");

    public void navTo() {
        driver.get("https://city-of-london-golf-courses.book.teeitup.golf/login");
    }

    public void username(String username) {
        sendKey(usernameBy, username);
    }

    public void password(String password) {
        sendKey(passwordBy, password);
    }

    public void login() {
        click(loginButtonBy);
    }
}
