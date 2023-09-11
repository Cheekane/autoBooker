package com.autoBooker.page;

import com.autoBooker.ElementHandler1;
import com.autoBooker.component.BookNowCard1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Booking1 extends ElementHandler1 {
    /*

     */
    public Booking1(WebDriver driver) {
        super(driver);
    }

    public void navTo(GolfCourse1 course, Calendar bookOn, int golfers, int startHr, int endHr, Holes1 holes) {
        String url = "https://city-of-london-golf-courses.book.teeitup.golf/?course=%d&date=%s&start=%d&end=%d&golfers=%d&holes=%d";
        driver.get(String.format(url, course, bookOn.getTime(), startHr, endHr, golfers, holes.getCount()));
    }

    public List<BookNowCard1> getAvailableCards() {
        List<BookNowCard1> cards = new ArrayList<>();
        String cardXPath = "//div[@data-testid='tee-time-content-body']/div[@style]//div[button]";
        By cardsBy = By.xpath(cardXPath);
        int cardCount = countElements(cardsBy);
        for (int i = 1 ; i <= cardCount; i++) {
            cards.add(new BookNowCard1(this.driver, cardXPath + "[" + i + "]"));
        }
        return cards;
    }
}
