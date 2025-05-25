package eu.senla.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
  private static Properties property;

  static {
    try {
      property = new Properties();
      FileInputStream propertyFile =
          new FileInputStream("src/test/java/eu/senla/resources/conf.properties");
      property.load(propertyFile);
    } catch (IOException e) {
      System.err.println("Error: Properties file isn't present!");
    }
  }

  public static String getProperty(String key) {
    return property.getProperty(key);
  }
}
