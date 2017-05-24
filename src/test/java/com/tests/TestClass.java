package com.tests;

import com.google.inject.Inject;
import com.laranerds.tests.pages.SampleDepe;
import com.laranerds.tests.configuration.ModuleFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * Created by Yuvaraj on 23/05/2017.
 */
//@Guice(modules = GuiceModule.class)
@Guice(moduleFactory = ModuleFactory.class)
public class TestClass {

    @Inject
    SampleDepe sampleDepe;

    @Inject
    WebDriver driver;

    @Test
    public void testmethod() {
        driver.get("http://google.com");
        sampleDepe.displayMethod();
    }
}
