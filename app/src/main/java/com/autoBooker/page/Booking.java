package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import com.autoBooker.component.BookNowCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Booking extends ElementHandler {
    public Booking(WebDriver driver) {
        super(driver);
    }

    public void navTo(GolfCourse course, Calendar bookOn, int golfers, int startHr, int endHr, Holes holes) {
        String url = "https://city-of-london-golf-courses.book.teeitup.golf/?course=%d&date=%s&start=%d&end=%d&golfers=%d&holes=%d";
        driver.get(String.format(url, course, bookOn.getTime(), startHr, endHr,golfers, holes.getCount()));
    }

    public List<BookNowCard> getAvailableCards() {
        List<BookNowCard> cards = new ArrayList<>();
        String cardXPath = "//div[@class='jss385']";
        By cardsBy = By.xpath(cardXPath);
        int cardCount = countElements(cardsBy);
        for (int i = 1 ; i <= cardCount; i++) {
            cards.add(new BookNowCard(this.driver, cardXPath + "[" + i + "]"));
        }
        return cards;
    }
}
