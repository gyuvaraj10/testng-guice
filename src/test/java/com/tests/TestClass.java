package com.tests;

import com.google.inject.Inject;
import com.laranerds.tests.pages.SampleDepe;
import com.laranerds.tests.configuration.ModuleFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

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
        sampleDepe.displayMethod2();
        sampleDepe.displayMethod3();
    }
}
