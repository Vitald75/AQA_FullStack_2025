package eu.senla;

import eu.senla.elements.SidePanel;
import eu.senla.pages.DashBoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class DashBoardTest extends BaseTest {

    @Test (testName = "Проверка страницы DashBoard", groups = {"smoke"})
    public void validateDashBoardPage() {
        DashBoardPage dashBoardPage = new SidePanel()
                .openDashBoardPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashBoardPage.isTimeAtWorkDisplayed(), "Tile TimeAtWork is not present");
        softAssert.assertTrue(dashBoardPage.isMyActionDisplayed(), "Tile MyAction is not present");
        softAssert.assertTrue(dashBoardPage.isBuzzLatestPostsDisplayed(), "Tile BuzzLatestPosts is not present");
        softAssert.assertTrue(dashBoardPage.isEmployeeByLocationDisplayed(), "Tile EmployeeByLocation is not present");
        softAssert.assertTrue(dashBoardPage.isEmployeeBySubUnitDisplayed(), "Tile EmployeeBySubUnit is not present");
        softAssert.assertTrue(dashBoardPage.isQuickLaunchDisplayed(), "Tile QuickLaunch is not present");
        softAssert.assertTrue(dashBoardPage.isEmployeesOnLeaveDisplayed(), "Tile EmployeesOnLeave is not present");
        softAssert.assertAll();

        Assert.assertTrue(dashBoardPage.getCurrentUrl().contains(dashBoardPage.getOwnPageUrl()), "Unexpected Url");

    }

}
