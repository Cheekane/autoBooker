package com.autoBooker.component;

import com.autoBooker.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookNowCard extends ElementHandler {
    private final String xPath;
    private String timeAsText;

    // needs WebDriver and XPath
    public BookNowCard(WebDriver driver, String xPath) {
        super(driver); // call parent constructor with the driver parameter "WebDriver driver"
        this.xPath = xPath;
    }

    // need to get the time of the BookNowCard returns timeAsText
    public String getTimeAsString() {
        if(this.timeAsText == null) {
            WebElement time = getElement(By.xpath(xPath + "//p[@data-testid='teetimes-tile-time'"));
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
        return Integer.parseInt(time.split(":")[1]); // gets the minutes after splitting, hence "[1]"
    }

    public int getTimeAsMin() {
        int hr = getFullHr(), min = getMin();
        return hr * 60 + min;
    }

    public void bookNow() {
        click(By.xpath(this.xPath));
    }
}
