package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //junit annotation
@CucumberOptions(
        features = "src/test/resources/features", //the path of the feature files
        glue = "com.saucedemo.step_definitions", //the path of the step definitions and Hook classes
        dryRun = false,  //true: runs feature files to generate step definitions
                         //false: first runs step definitions, then feature file to generate missing step definitions
        tags = "@shoppingSteps", //the test we want to run //tags can be shared
        plugin = {"html:target/default-cucumber-reports", //to report our test (html,junit,pretty, Json)
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class CucumberRunner {
}
// we can also add :monochrome: true//display the console output in a proper readable format
//              format: to generate different types of reporting
//              strict: true//it will check if any step is not defined in step definition file

