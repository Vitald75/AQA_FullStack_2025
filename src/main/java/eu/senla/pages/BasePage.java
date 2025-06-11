package eu.senla.pages;

import eu.senla.core.Driver;

/**
 * Где абстрактный метод?
 * Если его нет, зачем класс тогда абстрактный?
 */
public abstract class BasePage {

  public final String getCurrentUrl() {
    return Driver.getInstance().getCurrentUrl();
  }
}
