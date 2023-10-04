package com.MyComp_Onbording.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    private static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    public static WebDriver driver() {

        String browser =  ConfigReader.getProperty("browser");
        LOGGER.info("******* Browser is -> " + browser + " ********");

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--start-maximized");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--allow-insecure-localhost");
                options.addArguments("--acceptInsecureCerts");
                options.addArguments("disable-infobars");
                //  options.addArguments("--headless");
                tlDriver.set(driver = new ChromeDriver(options));
                break;
            case "edge":
                tlDriver.set(driver = new EdgeDriver());
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addArguments("--ignore-certificate-errors");
                firefoxOptions.addArguments("--allow-insecure-localhost");
                firefoxOptions.addArguments("--acceptInsecureCerts");
                firefoxOptions.addArguments("disable-infobars");
                // firefoxOptions.addArguments("--headless");
                tlDriver.set(driver = new FirefoxDriver(firefoxOptions));
                break;
        }

        driver.manage().window().maximize();
        LOGGER.info("Window size: " + driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageInitializer.init();
        return driver;
    }

}
