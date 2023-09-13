package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.WebDriver;

public enum Golfers {
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int golfersNum;

    Golfers(int golfersNum) {
        this.golfersNum = golfersNum;
    }

    public int golfersNum() {
        return this.golfersNum;
    }
}
