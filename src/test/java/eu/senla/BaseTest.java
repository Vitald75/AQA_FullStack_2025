package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Driver;
//import eu.senla.registration.ApiLoginImpl;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.registration.ApiLoginImpl;
import eu.senla.registration.FormLoginImpl;
import eu.senla.registration.LoginStrategy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



@Slf4j
public class BaseTest {

  @SneakyThrows
  @BeforeClass
  final void chooseLoginStrategy() {
    init();
    log.info("run init");
    System.out.println("run init");

    // Выбор стратегии аутентификации
    LoginStrategy authenticate = ReadPropertiesFile.getProperty("LOGIN_STRATEGY").trim().equals("API")
            ? new ApiLoginImpl(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.DASHBOARD_URL)
            : new FormLoginImpl();
    authenticate.login();
  }

  final void init() {
    Driver.getInstance().get(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL);
  }

  @AfterClass (alwaysRun = true)
  final void tearDown() {
    if (Driver.getInstance() != null) {
      Driver.driverTearDown();
    }
  }

}
