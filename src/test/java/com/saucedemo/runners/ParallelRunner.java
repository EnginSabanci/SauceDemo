package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
mvn test -P ParallelTesting - to kick off parallel testing. We have ParallelTesting profile in pom.xml file. Profiles let's to have multiple build configurations.
Also, ParallelTesting profile runs ParallelRunner.java class.
ParallelRunner class has list of features that were selected for ParallelTesting.
We can use parallel testing for regression test.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        glue = "com/saucedemo/step_definitions",
        dryRun = false,
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class ParallelRunner {
}
