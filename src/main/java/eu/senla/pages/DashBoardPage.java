package eu.senla.pages;

import eu.senla.core.Driver;
import eu.senla.elements.SidePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


//@Getter
public class DashBoardPage extends BasePage {

    private WebDriver driver;
    private SidePanel sidePanel;
    private final By sidePanelBody= By.cssSelector(".oxd-sidepanel-body");

    public DashBoardPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sidePanelBody));
        this.sidePanel = new SidePanel(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
