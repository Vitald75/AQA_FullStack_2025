package eu.senla.pages.admin;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class AdminMainPage extends BasePage {

    private final By dropdownJob = By.xpath("//span[text()='Job ']");
  //private final By dropdownJob = By.xpath("//*[@class='oxd-icon bi-chevron-down']");

    private final By menuItemJobTitles = By.xpath("//a[text()='Job Titles' and @role='menuitem']");


    public final AdminMainPage openJobMenu() {
        Wait.waitVisibilityOfElementLocated(dropdownJob).click();
        return this;
    }

    public final AdminViewJobTitlesListPage clickJobTitlesMenuItem() {
        Wait.waitVisibilityOfElementLocated(menuItemJobTitles).click();
        return new AdminViewJobTitlesListPage();
    }



}
