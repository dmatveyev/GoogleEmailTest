package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private By identifierId = By.id("identifierId");
    private By identifierNext = By.id("identifierNext");
    private By passwordElement = By.name("password");
    private By passwordNext = By.id("passwordNext");

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage enterLogin(String login) {
        webDriver.findElement(identifierId).sendKeys(login);
        webDriver.findElement(identifierNext).click();
        return this;
    }

    public LoginPage enterPassword(String password) {
        webDriver.findElement(passwordElement).sendKeys(password);
        final WebElement myElement = webDriver.findElement(passwordNext);
        final JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click();", myElement);
        return this;
    }
}
