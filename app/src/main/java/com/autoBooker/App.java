package com.autoBooker;

import com.autoBooker.component.BookNowCard;
import com.autoBooker.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;

public class App {

    public static void book(String username, String password) {

        int golfers = 4, startHr = 9, endHr = 24;

        WebDriver driver = new ChromeDriver();
        Login loginPage = new Login(driver);
        loginPage.navTo();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Booking bookingPage = new Booking(driver);

        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_WEEK, 6);
        bookingPage.navTo(GolfCourse.ThamesClassic, nextWeek, golfers, startHr, endHr, Holes.EIGHTEEN);
        List<BookNowCard> availableCards = bookingPage.getAvailableCards();

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
                if (closestCard != null) {
                    closestCard.bookNow();
                }
                break;
            }
            catch (NoSuchElementException e) {
                availableCards = bookingPage.getAvailableCards();
            }
        }
        BookingOptions bookingOptions = new BookingOptions(driver);
        bookingOptions.clickGolfers(Golfers.FOUR);
        bookingOptions.clickCheckout();
    }

    public static void main(String[] args) {
        String username = "username";
        String password = "password";

        book(username, password);
    }
}
