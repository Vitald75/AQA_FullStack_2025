package eu.senla;

import eu.senla.elements.SidePanel;
import eu.senla.pages.DashBoardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashBoardTest extends BaseTest {

    @Test
    @Tag("smoke")
    @DisplayName("Проверка страницы DashBoard")
    public void validateDashBoardPage() {
        DashBoardPage dashBoardPage = new SidePanel()
                .openDashBoardPage()
                .checkIfMyActionIsDisplayed()
                .checkIfBuzzLatestPostsIsDisplayed()
                .checkIfEmployeeByLocationIsDisplayed()
                .checkIfEmployeeBySubUnitIsDisplayed()
                .checkIfEmployeesOnLeaveIsDisplayed()
                .checkIfQuickLaunchIsDisplayed()
                .checkIfTimeAtWorkIsDisplayed();

        assertTrue(dashBoardPage.getCurrentUrl().contains(dashBoardPage.getOwnPageUrl()), "Unexpected Url");

    }

}
