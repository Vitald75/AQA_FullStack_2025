package eu.senla.registration;

import eu.senla.core.ReadPropertiesFile;
import eu.senla.pages.LoginPage;

public class FormLoginImpl implements LoginStrategy {

  @Override
  public final void login() throws Exception {
      new LoginPage()
              .loginAsValidUser(ReadPropertiesFile.getProperty("USERNAME"),
              ReadPropertiesFile.getProperty("PASSWORD"));
      }
}
