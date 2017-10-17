package com.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.laranerds.tests.listners.HookableListner;
import com.laranerds.tests.listners.InvokedMethodListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.laranerds.tests.configuration.ModuleFactory;
import org.testng.annotations.Guice;

@Guice(moduleFactory = ModuleFactory.class)
@Listeners(value = {HookableListner.class, InvokedMethodListener.class})
public class TestClass {

    @Inject
    Provider<WebDriver> driver;

    @BeforeMethod
    public void beforeTest() {
        driver.get().get("http://google.com");
    }

    @AfterMethod
    public void afterTest() {
        driver.get().close();
        driver.get().quit();
    }
}
