package eu.senla.pages.recruitment;

import eu.senla.core.Wait;
import eu.senla.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

public class RecruitmentPage extends BasePage {

    @Getter
    private final String ownPageUrl =
            "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";


    private final By addRecruitmentButton =
            By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[type='button']");


    public RecruitmentPage() {
        Wait.waitVisibilityOfElementLocated(addRecruitmentButton).isDisplayed();
    }

    public final AddCandidatePage clickAddRecruitmentButton() {
        Wait.waitVisibilityOfElementLocated(addRecruitmentButton).click();
        return new AddCandidatePage();
    }


}
