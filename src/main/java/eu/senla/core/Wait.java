package eu.senla.core;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Wait {
  static final Duration TIMEOUT = Duration.ofSeconds(7);

  public static WebElement wait(final ExpectedCondition<WebElement> expectedCondition) {
    return new WebDriverWait(Driver.getInstance(), TIMEOUT)
        .withMessage("The element isn't visible")
        .until(expectedCondition);
  }

  public static WebElement waitVisibilityOfElementLocated(final By locator) {
    return wait(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  private Wait() {
    throw new UnsupportedOperationException("This is a utility class and can't be instantiated");
  }
}
