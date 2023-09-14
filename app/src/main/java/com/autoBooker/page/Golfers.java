package com.autoBooker.page;

import com.autoBooker.ElementHandler;
<<<<<<< HEAD
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

=======
import org.openqa.selenium.WebDriver;

public enum Golfers {
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int golfersNum;

    Golfers(int golfersNum) {
        this.golfersNum = golfersNum;
    }

    public int getNum() {
        return this.golfersNum;
    }
>>>>>>> origin/master
}
