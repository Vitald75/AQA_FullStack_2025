package eu.senla.pages;

import eu.senla.core.Wait;
import org.openqa.selenium.By;

public class RecruitmentPage {
//    private final String recruitmentPageUrl =
//            "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";

    private final By addRecruitmentButton =
            By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");


    public RecruitmentPage() {
        Wait.waitVisibilityOfElementLocated(addRecruitmentButton);
    }

    public final AddCandidatePage clickAddRecruitmentButton() {
        Wait.waitVisibilityOfElementLocated(addRecruitmentButton).click();
        return new AddCandidatePage(); // вернуть новый PO   new AddRecruitmentPage()
    }


}
