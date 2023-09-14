package com.autoBooker.page;

import javax.swing.text.Element;
import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GolfersSelection extends ElementHandler {

    public GolfersSelection(WebDriver driver) {
        super(driver);
    }

    public void click(Golfers golfersNum) {
        By golfersBy = By.xpath("//div[@data-testid=\"player-count\"]//button[" + (golfersNum.getNum() - 1) + "]");
        click(golfersBy); // gets golfersNum - 1 index of buttons available
    }

}
