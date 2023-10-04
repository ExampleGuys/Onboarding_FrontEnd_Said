package com.MyComp_Onbording.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        String path = "src/test/resources/configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Configuration file couldn't found.");
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
