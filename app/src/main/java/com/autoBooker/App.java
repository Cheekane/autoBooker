package com.autoBooker;

import com.autoBooker.component.BookNowCard;
import com.autoBooker.page.*;
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

        int golfers = 4, startHr = 9, endHr = 24;

        WebDriver driver = new ChromeDriver();
        Login loginPage = new Login(driver);
        loginPage.navTo();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Booking bookingPage = new Booking(driver);

        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_WEEK, 7);
//        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd"); // when concatenating, java knows it the time should be in String format
//        String bookDate = simpleFormat.format(nextWeek.getTime());
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

        Golfers golfersNum = new Golfers(driver);
        golfersNum.click(4);


    }

    public static void main(String[] args) {
        String username = "g.nahan75@gmail.com";
        String password = "ar1eth2ac";

        book(username, password);
    }
}
