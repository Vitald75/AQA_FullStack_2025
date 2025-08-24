package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Driver;
//import eu.senla.registration.ApiLoginImpl;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.registration.ApiLoginImpl;
import eu.senla.registration.FormLoginImpl;
import eu.senla.registration.LoginStrategy;
import lombok.SneakyThrows;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

  @SneakyThrows
  @BeforeTest
  final void chooseLoginStrategy() {

    init();

    // Выбор стратегии аутентификации
    LoginStrategy authenticate = ReadPropertiesFile.getProperty("LOGIN_STRATEGY").trim().equals("API")
            ? new ApiLoginImpl(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.DASHBOARD_URL)
            : new FormLoginImpl();
    authenticate.login();

  }

  final void init() {
    Driver.getInstance().get(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL);
  }

  @AfterTest
  final void tearDown() {
    if (Driver.getInstance() != null) {
      Driver.getInstance().quit();
    }
  }

}
