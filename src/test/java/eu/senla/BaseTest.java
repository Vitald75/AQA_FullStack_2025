package eu.senla;

import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import eu.senla.registration.ApiLoginImpl;
//import eu.senla.registration.FormLoginImpl;
import eu.senla.registration.FormLoginImpl;
import eu.senla.registration.LoginStrategy;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

  @SneakyThrows
  @BeforeEach
  final void chooseLoginStrategy() {
    String dashboardUrl =
            "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    init();

    // Выбор стратегии аутентификации
    //LoginStrategy authenticate = new ApiLoginImpl(dashboardUrl);
    LoginStrategy authenticate = new FormLoginImpl();
    authenticate.login();
  }

  final void init() {
    Driver.getInstance().get(ReadPropertiesFile.getProperty("LOGIN_URL"));
  }

  @AfterEach
  final void tearDown() {
    Driver.quit();
  }

}
