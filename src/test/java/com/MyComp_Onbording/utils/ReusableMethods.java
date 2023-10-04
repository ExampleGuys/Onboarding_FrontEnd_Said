package com.MyComp_Onbording.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ReusableMethods extends PageInitializer{

    private static final Logger LOGGER = LogManager.getLogger(ReusableMethods.class);

    //===============Explicit Wait==============//
    public static void waitForPresenceOfElement(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitVisibleByLocator(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LOGGER.error("Web element is not visible!");
        }
        return element;
    }

    public static WebElement waitClickableByOfElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            LOGGER.error("Web element is not clickable!");
        }
        return element;
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            LOGGER.info("Waiting for page to load...");
            webDriverWait.until(expectation);
        } catch (Throwable error) {
            LOGGER.error("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    public static String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public static void hoverElement(WebElement webElement, int second) {
        Actions action = new Actions(getDriver());
        action.moveToElement(webElement).pause(Duration.ofSeconds(second)).perform();
    }

    public static String strValidEmail = getSaltString() + "@email.com";

    public static String checkHexCodeElementWithValue(WebElement webElement, String cssValue) {
        String element = waitVisibleByLocator(webElement).getCssValue(cssValue);
        return Color.fromString(element).asHex();
    }

    public static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

    public static String getTextElement(WebElement element) {
        return waitVisibleByLocator(element).getText();
    }

    public static WebElement setTextElement(WebElement webElement, String text) {
        WebElement element = waitVisibleByLocator(webElement);
        element.clear();
        element.sendKeys(text);

        return element;
    }

    public static boolean isDisplayElement(WebElement webElement) {
        return waitVisibleByLocator(webElement).isDisplayed();
    }

    public static boolean isEnableElement(WebElement webElement) {
        return waitVisibleByLocator(webElement).isEnabled();
    }

    public static String getAttributeElement(WebElement webElement, String attribute) {
        return waitVisibleByLocator(webElement).getAttribute(attribute);
    }

    public static String getCssValueElement(WebElement webElement, String cssValue) {
        return waitVisibleByLocator(webElement).getCssValue(cssValue);
    }

    public static void assertContains(Object actual, Object... expected) {
        assertTrue(Arrays.asList(expected).contains(actual), "text did not match");
    }

    public static void clickElement(WebElement webElement) {
        WebElement element = waitVisibleByLocator(webElement);
        waitClickableByOfElement(element).click();
    }

    public static String getTabTitle() {
        return getDriver().getTitle();
    }


    // ========= JS METHODS =========== //

    // CLICK WITH JS
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    // CLICK WITH JS
    public static void clickWithJSWithoutScroll(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }


    // SCROLL TO ELEMENT WITH JS
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    // SET ATTRIBUTE WITH JS
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }


    // ===========  JS COMMAND EXECUTE  =========== //

    // EXECUTES THE GIVEN JAVASCRIPT command on given web element
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript(command, element);
    }

    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript(command);
    }

    // Silinmeyen Texboxlari temizlemek icin ==> .clean() in daha guclusu
    public static void cleanByJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].value = '';", element);
    }

    public static List<String> getDropdownValue(WebElement webElement) {
        Select select = new Select(webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)));
        return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void selectDropdownValue(WebElement webElement, int index) {
        Select select = new Select(webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)));
        select.selectByIndex(index);
    }


    public static void switchToWindow(String targetTitle) {
        String origin = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(origin)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    public static void switchToNewWindow() {
        String origin = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(origin)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    public static String takeScreenShot(String methodName, boolean isFail) {

        try {
            String fail = isFail ? "FailTest" : "TestResult";
            SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
            String time = formatterDate.format(new Date());

            String screenshotLoc = System.getProperty("user.dir") + File.separator + "ScreenshotFile" + File.separator + fail + File.separator + time + "_" + methodName.replaceAll(" ", "") + ".png";

            File srcFiler = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(srcFiler, new File(screenshotLoc));
            return screenshotLoc;
        } catch (IOException e) {
            LOGGER.error("Error occurred in screenshot file operations!", e);

            fail(e.getMessage());

            return null;
        }
    }

    public static String fromTextToURL(String FromTextToURL) {
        String text = FromTextToURL;

        char[] trChar = new char[]{'İ', 'ı', 'ü', 'Ü', 'ç', 'Ç', 'Ğ', 'ğ', 'Ş', 'ş', 'ö', 'Ö', ' ', 'A', 'Y', ' '};
        char[] enChar = new char[]{'i', 'i', 'u', 'u', 'c', 'c', 'g', 'g', 's', 's', 'o', 'o', '-', 'a', 'y', ' '};
        for (int i = 0; i < trChar.length; i++) {
            text = text.replace(trChar[i], enChar[i]).toLowerCase();
        }
        return text;
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1) try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (WebDriverException we) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        // create destination as : filepath + filename + timestamp + .png
        String destination = System.getProperty("user.dir") + "/target/Screenshots/" + filename + date + ".png";

        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return picBytes;
    }
    public static void wait(int time){
        try {
            Thread.sleep(time*1000);
        } catch (Exception e) {

        }
    }
    public static void clickHamburgerIcon() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return document.querySelector('hamburger-menu').shadowRoot.querySelector('.hamburger-menu')");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()",shadowRoot);
    }
    public static void clickProfilerIcon() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return document.querySelector('customer-widget').shadowRoot.querySelector('.customer-widget')");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()",shadowRoot);
    }
    public Boolean isExist(WebElement element) {
        return element != null;
    }

}
