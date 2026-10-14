package com.pragma.credito.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.pragma.credito.bdd.steps",
        "com.pragma.credito.bdd.tasks",
        "com.pragma.credito.bdd.questions",
        "com.pragma.credito.bdd.abilities"
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml"
    },
    monochrome = false,
    tags = "@smoke or @regression",
    dryRun = false
)
public class RunCucumberTest {
}