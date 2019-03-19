package com.laranerds.tests.configuration;

import com.google.inject.*;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.laranerds.tests.annotations.Mobile;
import com.laranerds.tests.annotations.Report;
import com.laranerds.tests.annotations.Web;
import com.laranerds.tests.pages.SampleDepe;
import com.laranerds.tests.scopes.TestMethodScoped;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).annotatedWith(Mobile.class).toProvider(MobileDriverProvider.class).in(TestMethodScoped.class);
        bind(WebDriver.class).annotatedWith(Web.class).toProvider(WebDriverProvider.class).in(TestMethodScoped.class);
        bind(SampleDepe.class).in(TestMethodScoped.class);
        Names.bindProperties(binder(), getProperties());
        bindListener(Matchers.any(), new PageListner());
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Report.class), new MethodInterceptorClass());
    }


    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(this.getClass().getResource("/laranerds.properties").getPath())));
            return properties;
        }
        catch (Exception ex) {
            return properties;
        }
    }

}
