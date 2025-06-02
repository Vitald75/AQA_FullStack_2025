package eu.senla;

// import org.junit.jupiter.api;
import eu.senla.core.Driver;
import eu.senla.core.ReadPropertiesFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

  @BeforeEach
  final void init() {
    Driver.getInstance().get(ReadPropertiesFile.getProperty("LOGIN_URL"));
  }

  @AfterEach
  final void tearDown() {
    Driver.quit();
  }
}
