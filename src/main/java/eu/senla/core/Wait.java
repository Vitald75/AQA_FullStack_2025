package eu.senla.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class Wait {

  static final int TIMEOUT_SEC = 7;
  static final Duration TIMEOUT = Duration.ofSeconds(TIMEOUT_SEC);

  public static WebElement waitVisibilityOfElementLocated(final By locator) {
    return new WebDriverWait(Driver.getInstance(), TIMEOUT)
            .withMessage("The element isn't visible")
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static boolean waitTextToBePresentInElement(final By locator, String expectedText) {
    return new WebDriverWait(Driver.getInstance(), TIMEOUT)
            .withMessage("The element doesn't contain expected text")
            .until(ExpectedConditions.textToBePresentInElementValue(locator, expectedText));
  }

  private Wait() {
    throw new UnsupportedOperationException("This is a utility class and can't be instantiated");
  }

}
