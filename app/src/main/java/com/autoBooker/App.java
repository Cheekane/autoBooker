package com.autoBooker;

import com.autoBooker.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;

public class App {

    /*
    Takes tee time username and password and navigates through golf tee time Booking webpage
     */
    public static void book(String username, String password) {

        // start hours and end hours to search for
        int startHr = 9, endHr = 24;

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
        bookingOptions.clickAddToCart();
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