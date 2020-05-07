package Stepsdef;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.Reporter;

import java.io.File;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
        features = {"target/cucumber/features/[CUCABLE:FEATURE].feature"},
        plugin = {"json:target/cucumber-report/[CUCABLE:RUNNER].json","com.vimalselvam.cucumber.ExtentCucumberFormatter:output/report.html"},
        glue = {"Stepsdef"}
)

public class Runner extends AbstractTestNGCucumberTests {

}
