package eu.senla.core;

import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@UtilityClass
public final class ReadPropertiesFile {
  private Properties property;

  static {
    try {
      property = new Properties();
      FileInputStream propertyFile =
          new FileInputStream("src/test/resources/conf.properties");
      property.load(propertyFile);
    } catch (IOException e) {
      System.err.println("Error: Properties file isn't present!");
    }
  }

  public String getProperty(String key) {
    return property.getProperty(key);
  }
}
