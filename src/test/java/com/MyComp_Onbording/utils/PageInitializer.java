package com.MyComp_Onbording.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageInitializer extends Driver{


    private static final int DELAY = 10;

    //public static Onbording onbordingPage;

    public static WebDriverWait webDriverWait;
    public static void init() {

        //onbordingPage = new Onbording();
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(DELAY));
    }
}
