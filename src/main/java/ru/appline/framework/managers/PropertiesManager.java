package ru.appline.framework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private final Properties properties = new Properties();

    private static PropertiesManager INSTANCE = null;

    private PropertiesManager() {
        loadApplicationProperties();
    }

    public static PropertiesManager getPropertyManager() {
        if (INSTANCE == null) {
            INSTANCE = new PropertiesManager();
        }
        return INSTANCE;
    }

    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/prop/environment.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
