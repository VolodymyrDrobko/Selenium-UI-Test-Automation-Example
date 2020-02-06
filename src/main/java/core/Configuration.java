package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Configuration {
    private static String PROPERTY_FILE_NAME = "configuration.properties";
    private static String URL = System.getenv("URL");
    private static String BROWSER = System.getenv("BROWSER");
    private static String LOGIN = System.getenv("LOGIN");
    private static String PASSWORD = System.getenv("PASSWORD");

    private static String getPropertyByName(String propertyKey) {
        String propertyValue = "";
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" +
                File.separator + "main" + File.separator + "resources" + File.separator + PROPERTY_FILE_NAME)) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }

    public static String getURL() {
        return Optional.ofNullable(URL).orElse(getPropertyByName("url"));
    }

    public static String getBrowser() {
        return Optional.ofNullable(BROWSER).orElse(getPropertyByName("browser"));
    }

    public static String getLogin() {
        return Optional.ofNullable(LOGIN).orElse(getPropertyByName("login"));
    }

    public static String getPassword() {
        return Optional.ofNullable(PASSWORD).orElse(getPropertyByName("password"));
    }
}
