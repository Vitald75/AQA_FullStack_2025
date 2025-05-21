package eu.senla.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel {

    private WebDriver driver;

    private final By pim  = By.cssSelector("a[href$='viewPimModule']");
    private final By recruitmentPage = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");

    public SidePanel(WebDriver driver) {
        this.driver = driver;
    }

//    public PimPage clickPimMenu () {
//        driver.findElement(pim).click();
//        return new PimPage();
//    }
//


}
