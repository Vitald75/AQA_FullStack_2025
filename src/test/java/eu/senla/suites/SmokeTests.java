package eu.senla.suites;

import eu.senla.LoginPageTest;
import eu.senla.LogoutTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginPageTest.class, LogoutTest.class})
public class SmokeTests {

}
