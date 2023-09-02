/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package autoBooker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class App {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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

        calendar.add(Calendar.DAY_OF_WEEK, 7);
        Date nextWeekDate = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String nextWeekFormattedDate = dateFormat.format(nextWeekDate);

        By userLoggedInByXpath = By.xpath("//button[@data-testid='core-user-profile']");

        wait.until(ExpectedConditions.presenceOfElementLocated(userLoggedInByXpath));

        // get the website with all the appropriate settings (9 AM - 11 AM, 3-4 golfers, next week)
        driver.get("https://city-of-london-golf-courses.book.teeitup.golf/?course=9710&date=" + nextWeekDate + "&end=15&golfers=3,4&holes=18&start=09");

        try {
            By bookNowByXpath = By.xpath("//button[@data-testid='teetimes_book_now_button']");

            wait.until(ExpectedConditions.presenceOfElementLocated(bookNowByXpath));

            WebElement bookButton = driver.findElement(bookNowByXpath);
            bookButton.click();
        }
        catch (NoSuchElementException exception) {
            System.out.println("No available time from 9 AM to 11 AM");
            driver.get("https://city-of-london-golf-courses.book.teeitup.golf/?course=9710&date=" + nextWeekDate + "&end=20&golfers=3,4&holes=18&start=09");

        }
        finally {
            System.out.println("No availble time from 11 AM to 3 PM");
            driver.quit();
        }

        WebElement numGolfersButton = driver.findElement(By.xpath("//button[@data-testid=\"button-value-4\"]"));
        numGolfersButton.click();

        By checkoutButtonByXpath = By.xpath("//button[@data-testid=\"modal-rate-proceed-to-checkout-btn\"]");

        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButtonByXpath));

        WebElement proceedCheckoutButton = driver.findElement(checkoutButtonByXpath);
        proceedCheckoutButton.click();

        By agreeTermsByName = By.name("chb-nm");

        wait.until(ExpectedConditions.presenceOfElementLocated(agreeTermsByName));

        WebElement agreeTermsCheckbox = driver.findElement(agreeTermsByName);
        agreeTermsCheckbox.click();

        By purchaseButtonByXpath = By.xpath("//button[@data-testid=\"make-your-reservation-btn\"]");

        wait.until(ExpectedConditions.presenceOfElementLocated(purchaseButtonByXpath));

        WebElement purchaseButton = driver.findElement(purchaseButtonByXpath);
        purchaseButton.click();

        driver.quit();
    }


    public static void main(String[] args) {

        String[] email = {"g", "g"};
        String[] password = {"a"};

        for (int i = 0; i < 1; i++) {
            book(email[i], password[0]);

        }

    }
}
