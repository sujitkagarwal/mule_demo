package com.dev.sa.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Anie on 7/3/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue={"steps"},features ={"target/test-classes/features"},format={"pretty","json:target/cucumber.json","html:target/cucumber"},
strict=true
,monochrome = true
,tags = "~@wip")
public class ServiceTest {
}
