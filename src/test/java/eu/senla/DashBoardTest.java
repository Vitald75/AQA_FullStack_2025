package eu.senla;

import eu.senla.elements.SidePanel;
import eu.senla.pages.DashBoardPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashBoardTest extends BaseTest {

    @Test
    @Tag("smoke")
    @Tag("dashboard")
    @DisplayName("Проверка страницы DashBoard")
    public void validateDashBoardPage() {
        DashBoardPage dashBoardPage = new SidePanel()
                .openDashBoardPage();
        assertAll(
                "Grouped Assertions of User",
                () -> assertTrue(dashBoardPage.isTimeAtWorkDisplayed(), "Tile TimeAtWork is not present"),
                () -> assertTrue(dashBoardPage.isMyActionDisplayed(), "Tile MyAction is not present"),
                () -> assertTrue(dashBoardPage.isBuzzLatestPostsDisplayed(), "Tile BuzzLatestPosts is not present"),
                () -> assertTrue(dashBoardPage.isEmployeeByLocationDisplayed(), "Tile EmployeeByLocation is not present"),
                () -> assertTrue(dashBoardPage.isEmployeeBySubUnitDisplayed(), "Tile EmployeeBySubUnit is not present"),
                () -> assertTrue(dashBoardPage.isQuickLaunchDisplayed(), "Tile QuickLaunch is not present"),
                () -> assertTrue(dashBoardPage.isEmployeesOnLeaveDisplayed(), "Tile EmployeesOnLeave is not present")
        );

        assertTrue(dashBoardPage.getCurrentUrl().contains(dashBoardPage.getOwnPageUrl()), "Unexpected Url");

    }

}
