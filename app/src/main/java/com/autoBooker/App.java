package com.autoBooker;

import com.autoBooker.component.BookNowCard;
import com.autoBooker.page.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.List;

import static java.lang.Math.abs;

public class App {

    public static void book(String username, String password) {

        int startHr = 9, endHr = 11;

        WebDriver driver = new ChromeDriver();
        Login loginPage = new Login(driver);
        loginPage.navTo();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Booking bookingPage = new Booking(driver);

        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_WEEK, 7);
        bookingPage.navTo(GolfCourse.ThamesClassic, nextWeek, endHr, Golfers.FOUR, Holes.EIGHTEEN, startHr);
        bookingPage.getClosestCard().bookNow();

        BookingOptions bookingOptions = new BookingOptions(driver);
        bookingOptions.clickGolfers(Golfers.FOUR);
        bookingOptions.clickCheckout();

        Terms terms = new Terms(driver);
        terms.clickTerms();

        CompletePurchase purchase = new CompletePurchase(driver);
        purchase.clickPurchase();
    }

    public static void main(String[] args) {
        String username = "username";
        String password = "password";

        book(username, password);
    }
}