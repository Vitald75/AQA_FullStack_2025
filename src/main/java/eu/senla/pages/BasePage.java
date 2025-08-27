package eu.senla.pages;

import eu.senla.core.Driver;
import eu.senla.core.Wait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

@Slf4j
public class BasePage {

  public final String getCurrentUrl() {
    return Driver.getInstance().getCurrentUrl();
  }

  protected final Boolean isElementDisplayed(By elementLocator) {
    boolean result = false;
    try {
      result = Wait.waitVisibilityOfElementLocated(elementLocator).isDisplayed();
    } catch (TimeoutException e) {
      log.error("Element wasn't found: " + elementLocator);
      System.out.println("Element wasn't found: " + elementLocator);
    }
    return result;
  }

}
