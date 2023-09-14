package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Golfers extends ElementHandler {

    public Golfers(WebDriver driver) {
        super(driver);
    }

    public void click(int golfersNum) {
        By golfersButtonBy = By.xpath("//div[@class='MuiGrid-root jss463 MuiGrid-container']/button[" + (golfersNum - 1) + "]");
        click(golfersButtonBy);
    }

}
