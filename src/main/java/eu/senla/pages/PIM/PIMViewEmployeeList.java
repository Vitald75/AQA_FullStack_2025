package eu.senla.pages.PIM;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import org.openqa.selenium.By;

public class PIMViewEmployeeList extends BasePage {

    private final By addEmployeeButton =
            By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");

    private final By employeeFromTableRowFour =
            By.xpath("//div[@class='oxd-table-body']/child::div[4]");

    public final PIMAddEmployeePage clickAddEmployeeButton() {
        Wait.waitVisibilityOfElementLocated(addEmployeeButton).click();
        return new PIMAddEmployeePage();
    }

    public final PIMPersonalDetailsPage clickFoursEmployee() {
        Wait.waitVisibilityOfElementLocated(employeeFromTableRowFour).click();
        return new PIMPersonalDetailsPage();
    }
}
