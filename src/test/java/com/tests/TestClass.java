package com.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.laranerds.tests.annotations.Mobile;
import com.laranerds.tests.annotations.Web;
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
    @Web
    Provider<WebDriver> driver;

    @Inject
    @Mobile
    Provider<WebDriver> appDriver;

    @BeforeMethod
    public void beforeTest() {
        driver.get().get("http://google.com");
        appDriver.get().get("http://google.com");
    }

    @AfterMethod
    public void afterTest() {
        driver.get().quit();
        appDriver.get().quit();
    }
}
