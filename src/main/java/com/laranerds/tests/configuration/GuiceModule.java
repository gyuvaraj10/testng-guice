package com.laranerds.tests.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import com.laranerds.tests.pages.SampleDepe;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.AnnotatedElement;
import java.util.Properties;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).toProvider(DriverProvider.class).asEagerSingleton();
        Names.bindProperties(binder(), getProperties());
        bindListener(Matchers.any(), new PageListner());
        bind(SampleDepe.class);
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
