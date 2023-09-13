package com.autoBooker.component;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookNowCard extends ElementHandler {
    private final String xPath;
    private String timeAsText;
    private final int id;

    // needs WebDriver and XPath
    public BookNowCard(WebDriver driver, String xPathButton, int id) {
        super(driver); // call parent constructor with the driver parameter "WebDriver driver"
        this.xPath = xPathButton;
        this.id = id;
    }

    // need to get the time of the BookNowCard returns timeAsText
    public String getTimeAsString() {
        if(this.timeAsText == null) {
            WebElement time = getElement(By.xpath("//div[@data-testid='tee-time-content-body']/div[@style]//p[@data-testid='teetimes-tile-time'][" + id + "]"));
            // uses the xPath of the BookNowCard then adds specification of the "teetimes-tile-time"
            this.timeAsText = time.getText();
            // get text of WebElement specifying the time
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
    } // bug suspect AM/PM is trying to be turned into an integers

    public int getTimeAsMin() {
        int hr = getFullHr(), min = getMin();
        return hr * 60 + min;
    }

    public void bookNow() {
        click(By.xpath(this.xPath + "[" + id + "]"));
    } // clicks on the xpath element with the index as the id
}
