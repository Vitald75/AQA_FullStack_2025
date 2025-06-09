package eu.senla.pages;

import eu.senla.core.Driver;

public abstract class BasePage {

  public final String getCurrentUrl() {
    return Driver.getInstance().getCurrentUrl();
  }
}
