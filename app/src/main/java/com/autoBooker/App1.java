package com.autoBooker;

import com.autoBooker.component.BookNowCard1;
import com.autoBooker.page.Booking1;
import com.autoBooker.page.GolfCourse1;
import com.autoBooker.page.Holes1;
import com.autoBooker.page.Login1;
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

public class App1 {
    public static void book(String e, String p) {

        // create WebDriver obj "driver" and set to ChromeDriver
        WebDriver driver = new ChromeDriver();

        // maximize the window
        driver.manage().window().maximize();

        // request ChromeDriver to request HTTP for golf website
        driver.get("https://city-of-london-golf-courses.book.teeitup.golf/login");

        // create By object and get the username element on login
        By usernameById = By.id("txtUsername");

        // wait setting of max 15 s to hold for pull up delay
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameById));

        // driver finds username and password element and sends email and password
        driver.findElement(usernameById).sendKeys(e);
        driver.findElement(By.id("txtPassword")).sendKeys(p);

        // create button object for the button element and find by the className and click
        WebElement lgnButton = driver.findElement(By.className("MuiButton-label"));
        lgnButton.click();

        // to get the next week date
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // takes calendar and adds 7 days
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        Date nextWeekDate = calendar.getTime();
        // makes calendar into yyyy-MM-dd format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String nextWeekFormattedDate = dateFormat.format(nextWeekDate);

        By userLoggedInByXpath = By.xpath("//button[@data-testid='core-user-profile']");
        // wait for user profile button element to check if page is loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(userLoggedInByXpath));

        // get the website with all the appropriate settings (9 AM - 11 AM, 3-4 golfers, next week)
        driver.get("https://city-of-london-golf-courses.book.teeitup.golf/?course=9710&date=" + nextWeekDate + "&end=11&golfers=3,4&holes=18&start=09");
        By bookNowByXpath = By.xpath("//button[@data-testid='teetimes_book_now_button']");

        // gets book button element and tries to click
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(bookNowByXpath));

            WebElement bookButton = driver.findElement(bookNowByXpath);
            bookButton.click();
        }
        // catches exception if button element is not present and finds times from 11 AM - 3 PM
        catch (Exception exception) {
            driver.quit(); // REMOVE THIS IF YOU WANT 11 AM - 3 PM
            System.out.println("No available time from 9 AM to 11 AM");
            driver.get("https://city-of-london-golf-courses.book.teeitup.golf/?course=9710&date=" + nextWeekDate + "&end=15&golfers=3,4&holes=18&start=11");
        }

        // selects the "4 golfers" option
        WebElement numGolfersButton = driver.findElement(By.xpath("//button[@data-testid=\"button-value-4\"]"));
        numGolfersButton.click();

        // selects and clicks checkout button
        By checkoutButtonByXpath = By.xpath("//button[@data-testid=\"modal-rate-proceed-to-checkout-btn\"]");

        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButtonByXpath));

        WebElement proceedCheckoutButton = driver.findElement(checkoutButtonByXpath);
        proceedCheckoutButton.click();

        // selects and clicks agreement to terms button
        By agreeTermsByName = By.name("chb-nm");

        wait.until(ExpectedConditions.presenceOfElementLocated(agreeTermsByName));

        WebElement agreeTermsCheckbox = driver.findElement(agreeTermsByName);
        agreeTermsCheckbox.click();

        // selects and clicks the purchase button
        By purchaseButtonByXpath = By.xpath("//button[@data-testid=\"make-your-reservation-btn\"]");

        wait.until(ExpectedConditions.presenceOfElementLocated(purchaseButtonByXpath));

        WebElement purchaseButton = driver.findElement(purchaseButtonByXpath);
        purchaseButton.click();

        driver.quit();
    }

    public static void book2(String username, String password) {
        WebDriver driver = new ChromeDriver();

        // Login
        Login1 loginPage = new Login1(driver);
        loginPage.navTo();
        loginPage.username(username);
        loginPage.password(password);
        loginPage.login();

        // Find booking closest to 9am but less than 11am for 18 holes for 4 golfers for next week
        Booking1 bookingPage = new Booking1(driver);
        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_WEEK, 7);
        bookingPage.navTo(GolfCourse1.ThamesClassic, nextWeek, 4, 9, 11, Holes1.EightTeen);
        List<BookNowCard1> availableCards = bookingPage.getAvailableCards();

        // Find the closest card to 9am
        // First convert all times to min (from midnight) and compare.  eg: 9am is 540min (9 * 60)
        int nineAm = 9 * 60;
        int closestTime = Integer.MAX_VALUE;
        BookNowCard1 closestCard = null;
        for(BookNowCard1 card: availableCards) {
            int timeDiff = Math.abs(card.getTimeAsMin() - nineAm);
            if (timeDiff < closestTime) {
                closestCard = card;
            }
        }
        closestCard.bookNow();

        // etc...
    }

    public static void main(String[] args) {
        String email = "username";
        String password = "password";

        book(email, password);
    }
}