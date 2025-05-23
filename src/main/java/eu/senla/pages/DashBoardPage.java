package eu.senla.pages;

import eu.senla.core.Driver;
import eu.senla.core.Wait;
import eu.senla.elements.SidePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import static eu.senla.core.Driver.driver;


//@Getter
public class DashBoardPage {//extends BasePage {

    //private WebDriver driver;
    private SidePanel sidePanel;
    private final By sidePanelBody= By.cssSelector(".oxd-sidepanel-body");

    public DashBoardPage() {
        //super(driver);
        Wait.waitVisibilityOfElementLocated(sidePanelBody);
        this.sidePanel = new SidePanel();
    }

//    public String getUrl() {
//        return driver.getCurrentUrl();
//    }

}
