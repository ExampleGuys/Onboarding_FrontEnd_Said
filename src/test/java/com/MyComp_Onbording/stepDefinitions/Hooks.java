package com.MyComp_Onbording.stepDefinitions;

import com.MyComp_Onbording.pages.ResourcesPage;
import com.MyComp_Onbording.utils.Driver;
import com.MyComp_Onbording.utils.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.MyComp_Onbording.utils.Driver.getDriver;

public class Hooks {
    @Before
    public void start() {
        Driver.driver();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            picture = ReusableMethods.takeScreenshot("failed/" + scenario.getName());
            scenario.attach(picture, "image/png", scenario.getName());
        }
        if (getDriver() != null) {
            ReusableMethods.wait(1);
            getDriver().quit();
        }
    }

}
