package eu.senla.client;

import eu.senla.core.ReadPropertiesFile;
import eu.senla.pages.LoginPage;

public class LoginViaPageStrategy implements LoginStrategy {

  public LoginViaPageStrategy() {

  }

  @Override
  public final void accessPage() throws Exception {
      new LoginPage().loginAsValidUser(ReadPropertiesFile.getProperty("USERNAME"),
              ReadPropertiesFile.getProperty("PASSWORD")).getSidePanel().openPIMPage();
      }
}
