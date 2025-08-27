package eu.senla.core;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginCredentials")
     public static Object[][] provideLoginData() {
            return new Object[][]{
                    {"Admin", "1234564"},
                    {"WrongName", "admin123"},
                    {"AnyName", "43211"},
                    {"", ""}
            };
        }
    }


