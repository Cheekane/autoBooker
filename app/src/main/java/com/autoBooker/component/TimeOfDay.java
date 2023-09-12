package com.autoBooker.component;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeOfDay extends ElementHandler {

    private final String xPath;

    public TimeOfDay(WebDriver driver, String xPath) {
        super(driver);
        this.xPath = xPath;
    }

    public getTimeOfDay() {

    }
}
