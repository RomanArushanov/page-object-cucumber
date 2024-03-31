package ru.ibs.appline.framework.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@ConfigurationParameters({
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/FinalTaskTests.feature"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ru.appline.framework.steps"),
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Test_PageObjectCucumber_1"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "summary, pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"),
})
public class CucumberRunner {
}
