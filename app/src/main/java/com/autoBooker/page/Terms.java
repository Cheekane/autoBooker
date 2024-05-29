package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Terms extends ElementHandler {

    public Terms(WebDriver driver) {
        super(driver);
    }

    public void clickTerms() {
        By termsBy = By.xpath("//label[@data-testid=\"terms-and-conditions-checkbox\"]");
        click(termsBy); // uses By and getElement then clicks, *see ElementHandler*
    }
}
