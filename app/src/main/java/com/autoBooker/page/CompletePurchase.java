package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePurchase extends ElementHandler {

    public CompletePurchase(WebDriver driver) {
        super(driver);
    }

    public void clickPurchase() {
        By purchaseButtonBy = By.xpath("//button[@data-testid=\"make-your-reservation-btn\"]");
        click(purchaseButtonBy);
    }
}
