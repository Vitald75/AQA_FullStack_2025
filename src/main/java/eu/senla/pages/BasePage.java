package eu.senla.pages;

import eu.senla.core.Driver;
import eu.senla.core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class BasePage {

  public final String getCurrentUrl() {
    return Driver.getInstance().getCurrentUrl();
  }

  protected final Boolean isElementDisplayed(By elementLocator) {
    boolean result = false;
    try {
      result = Wait.waitVisibilityOfElementLocated(elementLocator).isDisplayed();
    } catch (TimeoutException e) {
      System.out.println("Element wasn't found: " + elementLocator);
    }
    return result;
  }

}
