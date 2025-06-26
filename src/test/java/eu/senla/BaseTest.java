package eu.senla;

import eu.senla.core.ConstantsClass;
import eu.senla.core.Driver;
//import eu.senla.registration.ApiLoginImpl;
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

    init();

    // Выбор стратегии аутентификации - одну закомментировать
    //LoginStrategy authenticate = new ApiLoginImpl(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.DASHBOARD_URL);
    LoginStrategy authenticate = new FormLoginImpl();

    authenticate.login();
  }

  final void init() {
    Driver.getInstance().get(ConstantsClass.MAIN_URL + ConstantsClass.WEB_EP + ConstantsClass.AUTH_LOGIN_URL);
  }

  @AfterEach
  final void tearDown() {
    Driver.quit();
  }

}
