package eu.senla.pages;

import eu.senla.core.Driver;

public abstract class BasePage {
  //  protected WebDriver driver;
  //  protected WebDriverWait wait;
  //
  //  public BasePage() {
  //    this.driver = Driver.getInstance();
  //    // PageFactory.initElements(driver, this);
  //  }

  public final String getUrl() {
    return Driver.getInstance().getCurrentUrl();
  }
}
