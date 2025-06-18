package eu.senla.core;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class Wait {

  static final int TIMEOUT_SEC = 7;
  static final Duration TIMEOUT = Duration.ofSeconds(TIMEOUT_SEC);

  //этот метод и ниже по сути одинаковые только один общий а второй более частный
  public static WebElement wait(final ExpectedCondition<WebElement> expectedCondition) {
    return new WebDriverWait(Driver.getInstance(), TIMEOUT)
        .withMessage("The element isn't visible")
        .until(expectedCondition);
  }

  public static WebElement waitVisibilityOfElementLocated(final By locator) {
    return wait(ExpectedConditions.visibilityOfElementLocated(locator));
  }

//  public static WebElement waitTextToBePresentedInElementValue(final By locator) {
//    return WebDriverWait(Driver.getInstance(), TIMEOUT)
//            .withMessage("").until(ExpectedConditions.textToBePresentInElementValue(locator,""))                    ;
//  }

  private Wait() {
    throw new UnsupportedOperationException("This is a utility class and can't be instantiated");
  }

}
