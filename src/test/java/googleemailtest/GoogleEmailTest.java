package googleemailtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailInbox;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

@Test
public class GoogleEmailTest {
    private static final String login = "denismatveyevaleksandrovich@gmail.com";
    private static final String password = "123qwe!@#QWE)";

    @FindBy
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
    }

    @Test
    public void sendEmail() {
        String to = "denismatveyevaleksandrovich@gmail.com";
        String subj = "Test email";
        String text = "Something text";
        MailInbox page = PageFactory.initElements(driver, MailInbox.class);
        page.sendMessage(to,subj,text);
        String actual = page.getLinkTextForNewMessage();
        assertEquals(actual, "Просмотреть сообщение");
    }

    @Ignore
    @Test
    public void findEmail() {
        final WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//tbody")));

        WebElement el = driver.findElement(By.xpath("//span[text()='Test email']"));
        Actions click = new Actions(driver);
        System.out.printf("Founded location, %s", el.getLocation());
        System.out.printf("Founded text, %s", el.getAttribute("innerText"));
        System.out.printf("Founded tag , %s", el.getTagName());


        By span = By.xpath("//span[text()='Test email']");
        WebElement lll = driver.findElement(span);

        click.moveToElement(el);
        click.click();

        WebElement dd = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//tbody/tr")));
        dd.click();
        assertNotNull(dd);

        Assert.assertEquals("get", "asdf", "asdfasdf");
    }
}
