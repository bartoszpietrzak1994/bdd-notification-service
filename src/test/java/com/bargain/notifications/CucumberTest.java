package com.bargain.notifications;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", tags = "not @ignore", plugin = {"pretty"})
public class CucumberTest {
}
