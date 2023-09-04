package com.autoBooker.component;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookNowCard extends ElementHandler {
    private final String xPath;
    private String timeAsText;

    public BookNowCard(WebDriver driver, String xPath) {
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
