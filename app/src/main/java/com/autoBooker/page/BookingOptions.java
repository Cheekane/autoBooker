package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingOptions extends ElementHandler {

    By addToCartBy = By.xpath("//button[@data-testid='add-to-cart-button']");
    By checkoutBy = By.xpath("//button[@data-testid='shopping-cart-drawer-checkout-btn']");

    // uses the same WebDriver to handle booking options
    public BookingOptions(WebDriver driver) {
        super(driver);
    }

    // clicks on number of golfers from golf booking card
    public void clickGolfers(Golfers golfers) {
        By golfersBy = By.xpath("//input[@data-testid='golfer-select-radio-" + golfers.getNum() + "']");
        click(golfersBy);
    }

    // clicks on add to cart button
    public void clickAddToCart() {
        click(addToCartBy);
        waitForElement(checkoutBy);
    }

    // clicks on shopping cart checkout button
    public void clickCheckout() {
        click(checkoutBy);
    }

}
