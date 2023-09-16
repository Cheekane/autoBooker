package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingOptions extends ElementHandler {

    By checkoutBy = By.xpath("//button[@data-testid='modal-rate-proceed-to-checkout-btn']");

    public BookingOptions(WebDriver driver) {
        super(driver);
    }

    public void clickGolfers(Golfers golfers) {
        By golfersBy = By.xpath("//div[@class='MuiDialogContent-root']//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//button[@type='button']");
        List<WebElement> golfersButtonList = getElements(golfersBy);
        golfersButtonList.get(2).click(); // gets golfersNum - 2 index of buttons available because array start = 0
    }

    public void clickCheckout() {
        click(checkoutBy);
    }

}
