package eu.senla.pages;

import eu.senla.core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage { //extends BasePage{
    //private WebDriver driver;
    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By invalidCredentialsAlert = By.xpath("//p[text()='Invalid credentials']");

//    public LoginPage (WebDriver driver) {
//        super(driver);
//    }

    public LoginPage enterUserName(String userName) {
        Wait.waitVisibilityOfElementLocated(userNameField).sendKeys(userName);
        //driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Wait.waitVisibilityOfElementLocated(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        Wait.waitVisibilityOfElementLocated(submitButton).click();
        return this;
    }

    public LoginPage loadPage(String url) {
        //Driver.get(url);
        Wait.waitVisibilityOfElementLocated(userNameField);
        return this;
    }

    public DashBoardPage loginAs(String userName, String password) {

        enterUserName(userName)
                .enterPassword(password)
                .clickSubmitButton();
        return new DashBoardPage();
    }

}
