package com.autoBooker.page;

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
}
