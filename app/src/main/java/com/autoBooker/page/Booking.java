package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import com.autoBooker.component.BookNowCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Booking extends ElementHandler {

    public Booking(WebDriver driver) {
        super(driver);
    }

    public void navTo(GolfCourse course, Calendar bookDate, int golfers, int startHr, int endHr, Holes holes) {
        String url = "https://city-of-london-golf-courses.book.teeitup.golf/?course=%d&date=%s&end=%d&golfers=%d&holes=%d&start=%d";
        driver.get(String.format(url, course.getCourseId(), bookDate.getTime(), endHr, golfers, holes.getCount(), startHr));
    }

    public List<BookNowCard> getAvailableCards() {
        List<BookNowCard> cards = new ArrayList<>(); // create ArrayList to store BookNowCards

        // "//" searches anywhere in the document, "/" searches the child element,
        // div searches for everywhere for div elements and have at least one child element that is a button
        String cardXPath = "//div[@data-testid='tee-time-content-body']/div[@style]//div[button]]"; // the xpath doesnt seem to work
        By cardsBy = By.xpath(cardXPath);
        int cardCount = countElements(cardsBy); // gets cardCount using countElements from ElementHandler
        for(int i = 1; i <= cardCount; i++) { // selenium starts at [1]
            cards.add(new BookNowCard(driver, cardXPath + "[" + i + "]")); // searches for 1 - i cardXPath findings
        }
        return cards;
    }
}
