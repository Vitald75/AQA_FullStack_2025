package eu.senla.pages;

import eu.senla.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage() {
    this.driver = Driver.getInstance();
    // PageFactory.initElements(driver, this);
  }

}
