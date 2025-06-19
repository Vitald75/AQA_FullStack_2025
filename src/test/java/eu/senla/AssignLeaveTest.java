package eu.senla;

import eu.senla.elements.SidePanel;
import eu.senla.pages.leave.AssignLeavePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class AssignLeaveTest extends BaseTest {

    @Test
    @DisplayName("Успешный Assign Leave")
    @Tag("smoke")
    public void testPositiveAssignLeave() {

        AssignLeavePage assignLeavePage =
                new SidePanel()
                        .openLeavePage()
                        .clickAssignLeaveMenu()
                        .inputEmployeeName("a")
                        .selectUserName()
                        //.clickLeaveTypeDropbox()
                        .chooseLeaveTypeFromDropbox("US - Vacation");

//        assertTrue(
//                addCandidatePage.getCurrentUrl().contains(
//                        addCandidatePage.getOwnPageUrl()),
//                "Unexpected Url");

    }
}
