package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "identifierId")
    private WebElement identifierId;
    @FindBy(id = "identifierNext")
    private WebElement identifierNext;
    @FindBy(name = "password")
    private WebElement passwordElement;
    @FindBy(id = "passwordNext")
    private WebElement passwordNext;

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage enterLogin(String login) {
        identifierId.sendKeys(login);
        identifierNext.click();
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordElement.sendKeys(password);
        final JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click();", passwordNext);
        return this;
    }
}
