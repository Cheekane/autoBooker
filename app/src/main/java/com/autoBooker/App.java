package com.autoBooker;

import com.autoBooker.component.BookNowCard;
import com.autoBooker.page.Booking;
import com.autoBooker.page.GolfCourse;
import com.autoBooker.page.Holes;
import com.autoBooker.page.Login;
import org.openqa.selenium.By;
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

public class App {

    public static void book(String username, String password) {

        int golfers = 4, startHr = 9, endHr = 10;

        WebDriver driver = new ChromeDriver();
        Login loginPage = new Login(driver);
        loginPage.navTo();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Booking bookingPage = new Booking(driver);

        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_WEEK, 7);
//        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String bookDate = simpleFormat.format(nextWeek);
        bookingPage.navTo(GolfCourse.ThamesClassic, nextWeek, golfers, startHr, endHr, Holes.EIGHTEEN);
        List<BookNowCard> availableCards = bookingPage.getAvailableCards();

        BookNowCard closestCard = null;
        for(BookNowCard card : availableCards) {
            int closestTime = Integer.MAX_VALUE;
            int tenAM = 10 * 60; // 10 AM in minutes
            int difference = tenAM - card.getTimeAsMin();
            if(difference < closestTime) {
                closestCard = card;
            }
        }
        if(closestCard != null) {
            closestCard.bookNow();
        }
    }

    public static void main(String[] args) {
        String username = "username";
        String password = "password";

        book(username, password);
    }
}
