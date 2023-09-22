package com.autoBooker.page;

import com.autoBooker.ElementHandler;
import com.autoBooker.component.BookNowCard;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class Booking extends ElementHandler {

    public Booking(WebDriver driver) {
        super(driver);
    }

    public void navTo(GolfCourse course, Calendar bookDate, int endHr, Golfers golfers, Holes holes, int startHr) {
        By profileBy = By.xpath("//button[@data-testid='core-user-profile']"); // implicitly waits for the account to be logged in properly
        waitForElement(profileBy);
        String url = "https://city-of-london-golf-courses.book.teeitup.golf/?course=%d&date=%s&end=%d&golfers=%d&holes=%d&start=%d";
        driver.get(String.format(url, course.getCourseId(), bookDate.getTime(), endHr, golfers.getNum(), holes.getCount(), startHr));
    }

    public List<BookNowCard> getAvailableCards() {
        List<BookNowCard> cards = new ArrayList<>(); // create ArrayList to store BookNowCards

        // "//" searches anywhere in the document, "/" searches the child element,
        // div searches for everywhere for div elements and have at least one child element that is a button
        String buttonXPath = "//div[@data-testid='tee-time-content-body']//button";
        By cardButtonBy = By.xpath(buttonXPath);
        List<WebElement> buttonList = getElements(cardButtonBy);

        String timeXPath = "//div[@data-testid='tee-time-content-body']/div[@style]//p[@data-testid='teetimes-tile-time']";
        By cardTimeBy = By.xpath(timeXPath);
        List<WebElement> timeList = getElements(cardTimeBy);

        int cardCount = countElements(cardButtonBy); // gets cardCount using countElements from ElementHandler
        for (int id = 0; id < cardCount; id++) {
            cards.add(new BookNowCard(driver, buttonList, timeList, id)); // searches for card with bookNowButton and adds
        }
        return cards;
    }
    public BookNowCard getClosestCard() {
        List<BookNowCard> availableCards = getAvailableCards();

        BookNowCard closestCard = null;
        // the card may become unavailable if someone books it and produces an error if that happens when trying to add BookNowCard
        while (true) {
            try {
                int closestDiff = Integer.MAX_VALUE;
                for (BookNowCard card : availableCards) {
                    int tenAM = 10 * 60; // 10 AM in minutes
                    int difference = abs(tenAM - card.getTimeAsMin());
                    if (difference < closestDiff) {
                        closestDiff = difference;
                        closestCard = card;
                    }
                }
                break;
            }
            catch (Exception e) { // not sure which exception type to use to catch the specific exception
                driver.navigate().refresh();
                availableCards = getAvailableCards();
            }
        }
        return closestCard;
    }
}
