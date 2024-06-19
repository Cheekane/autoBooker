package autoBooker;

import com.autoBooker.ElementHandler;
import com.autoBooker.page.Login;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LoginTest extends ElementHandler {
    Login login;
    ElementHandler elementHandler;

    public LoginTest(WebDriver driver) {
        super(driver);
    }

    @BeforeEach
    public void createDriver() {
        WebDriver driver = new ChromeDriver();
        login = new Login(driver);
        elementHandler = new ElementHandler(driver);
    }
    @Test
    public void login() {
        login.navTo();
        login.enterUsername("user");
        login.enterPassword("pass");
    }

}
