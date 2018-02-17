package ru.ssau.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class PropertiesLoader {

    private static PropertiesLoader propertiesLoader;
    private Properties properties;
    private static final String PROPERTIES_FILE_NAME = "config.properties";

    private PropertiesLoader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesLoader getInstance() {
        propertiesLoader = propertiesLoader == null ? new PropertiesLoader() : propertiesLoader;
        return propertiesLoader;
    }

    public Properties getProperties() {
        return properties;
    }
}
