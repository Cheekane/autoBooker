package com.autoBooker.component;

import com.autoBooker.ElementHandler1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookNowCard1 extends ElementHandler1 {
    private final String xPath; // string for the xpath
    private String timeAsText; // string for the time of BookNowCard

    public BookNowCard1(WebDriver driver, String xPath) {
        super(driver);
        this.xPath = xPath;
    }

    public void bookNow() {
        String bookNowXpath = this.xPath + "//button[@class='jss405']";
        click(By.xpath(bookNowXpath));
    }

    public int getTimeAsMin() {
        int hrAsMin = getHr() * 60;
        int min = getMin();
        return hrAsMin + min;
    }

    public int getHr() {
        String time = getTimeAsString();
        return Integer.parseInt(time.split(":")[0]);
    }

    public int getMin() {
        String time = getTimeAsString();
        return Integer.parseInt(time.split(":")[1].split(" ")[0]);
    }

    public String getTimeAsString() {
        if (this.timeAsText == null) {
            WebElement time = getElement(By.xpath(xPath + "//p[@class='jss388']"));
            this.timeAsText = time.getText();
        }
        return this.timeAsText;
    }
}