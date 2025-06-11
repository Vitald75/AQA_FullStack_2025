package eu.senla;

import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  // protected static WebDriver driver;
  // protected static Wait<WebDriver> wait;

  /**
   * определение стратегии должно быть здесь
   * как именно реавлизовать подумай сам
   * мне впадлу =)))))))))
   * если не получится - пиши, делай ПР, будем думать дальше вместе
   */


  @BeforeEach
  final void init() {
    Driver.getInstance().get(ReadPropertiesFile.getProperty("LOGIN_URL"));
  }

  @AfterEach
  final void tearDown() {
    Driver.quit();
  }

}
