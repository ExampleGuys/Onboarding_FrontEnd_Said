package com.MyComp_Onbording.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/default-html-reports.html",
        },
        glue = {
                "com/MyComp_Onbording/stepDefinitions",
              "com/MyComp_Onbording/stepDefinitions/Hooks"},
        features = "src/test/resources/features",
        dryRun = false,
        stepNotifications=false,
        tags ="@ONB2-213"
)
public class Runners {}