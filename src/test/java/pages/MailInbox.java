package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailInbox {

    private By writeMessage = By.xpath(".//*[text()='НАПИСАТЬ']/..");
    private By sendTo = By.xpath("//textarea[@name='to']");
    private By subjectBox = By.xpath("//input[@name='subjectbox']");
    private By textBox = By.xpath("//div[@role='textbox']");
    private By sendButton = By.xpath(".//*[text()='Отправить']/..");
    private By linkViewMessage = By.id("link_vsm");

    private WebDriver webDriver;
    private WebDriverWait wait;

    public MailInbox(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, 20);
    }

    public MailInbox getMessageForm() {
        WebElement createMessage = wait.until(ExpectedConditions.
                visibilityOfElementLocated(writeMessage));
        createMessage.click();
        return this;
    }

    public MailInbox sendMessage(String to, String subject, String text) {
        getMessageForm();
        WebElement toField = wait.until(ExpectedConditions.
                visibilityOfElementLocated(sendTo));
        toField.sendKeys(to);
        WebElement subjectField = wait.until(ExpectedConditions.
                visibilityOfElementLocated(subjectBox));
        subjectField.sendKeys(subject);
        WebElement textField = wait.until(ExpectedConditions.
                visibilityOfElementLocated(textBox));
        textField.sendKeys(text);
        WebElement send = wait.until(ExpectedConditions.
                visibilityOfElementLocated(sendButton));
        send.click();

        return this;
    }

    public String getLinkTextForNewMessage() {
        WebElement ok = wait.until(ExpectedConditions.
                visibilityOfElementLocated(linkViewMessage));
        return ok.getText();
    }



}
