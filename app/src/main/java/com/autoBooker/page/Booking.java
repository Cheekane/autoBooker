package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import com.autoBooker.component.BookNowCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Booking extends ElementHandler {

    public Booking(WebDriver driver) {
        super(driver);
    }
    /*
    course number
    9710 thames valley golf course classic
    9711 thames valley golf club hickory
    9714 fanshawe golf course traditional
    9713 fanshawe golf course the quarry
    https://city-of-london-golf-courses.book.teeitup.golf/?course=9710&date=2023-09-15&golfers=3,4&holes=18
     */
    public void navTo(GolfCourse course, bookOn date, int golfers, int startTime, int endTime, int holes) {
        String url = "https://city-of-london-golf-courses.book.teeitup.golf/?course=%d&date=%s&start=%d&end=%d&golfers=%d&holes=%d";
        driver.get(String.format(url, course, date, startHr, endHr, golfers, holes.getCount()));
    }

    public List<BookNowCard> getAvailableCards() {
        List<BookNowCard> cards = new ArrayList<>(); // create ArrayList to store BookNowCards
        /*
        "//" searches anywhere in the document, "/" searches the child element,
         div searches for everywhere for div elements and have at least one child element that is a button
         */
        String cardXPath = "//div[@data-testid='tee-time-content-body'/div[@style]//div[button]]";
        By cardsBy = By.xpath(cardXPath);
        int cardCount = countElements(cardsBy); // gets cardCount using countElements from ElementHandler
        for(int i = 0; i < cardCount; i++) {
            cards.add(new BookNowCard(driver, cardXPath));
        }
        return cards;
    }
}
