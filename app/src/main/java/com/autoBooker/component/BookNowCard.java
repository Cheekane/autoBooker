package com.autoBooker.component;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Math.abs;

public class BookNowCard extends ElementHandler {
    private final List<WebElement> buttonList, timeList;
    private String timeAsText;
    private final int id;

    // needs WebDriver and XPath
    public BookNowCard(WebDriver driver, List<WebElement> buttonList, List<WebElement> timeList, int id) {
        super(driver); // call parent constructor with the driver parameter "WebDriver driver"
        this.buttonList = buttonList;
        this.timeList = timeList;
        this.id = id;
    }

    public List<WebElement> getWebElementList(By by) {
        return getElements(by);
    }

    // need to get the time of the BookNowCard returns timeAsText
    public String getTimeAsString() {
        if(this.timeAsText == null) {
            this.timeAsText = timeList.get(id).getText();
            // get text of WebElement specifying the time, *get() for ArrayList
        }
        return this.timeAsText;
    }

    public int getHr() {
        String time = getTimeAsString();
        return Integer.parseInt(time.split(":")[0]); // gets the hours after splitting, hence "[0]"
    }

    // gets the hours in 24 hrs time
    public int getFullHr() {
        int hr;
        String timeAsText = getTimeAsString();
        String meridiem = timeAsText.split(" ")[1]; // splits the space between time and AM/PM
        if(meridiem.equalsIgnoreCase("PM")) { // if time is PM then add 12 to hr
            return hr = getHr() + 12;
        }
        else { // if time is AM
            return hr = getHr();
        }
    }

    public int getMin() {
        String time = getTimeAsString();
        String min = time.split(":")[1];
        String minAsString = min.split(" ")[0];
        return Integer.parseInt(minAsString); // gets the minutes after splitting, hence "[1]"
    }

    public int getTimeAsMin() {
        int hr = getFullHr(), min = getMin();
        return hr * 60 + min;
    }

    public void bookNow() {
        buttonList.get(id).click();
    } // clicks on the xpath element with the index as the id
}
