package eu.senla.pages.leave;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class ViewListLeavePage extends BasePage {

    private final By assignLeaveMenu = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item'][text()='Assign Leave']");



    public final AssignLeavePage clickAssignLeaveMenu() {
        Wait.waitVisibilityOfElementLocated(assignLeaveMenu).click();
        return new AssignLeavePage();
    }

}
