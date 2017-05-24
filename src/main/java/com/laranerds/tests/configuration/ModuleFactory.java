package com.laranerds.tests.configuration;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.laranerds.tests.configuration.GuiceModule;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

/**
 * Created by Yuvaraj on 23/05/2017.
 */
public class ModuleFactory implements IModuleFactory {

    public Module createModule(ITestContext iTestContext, Class<?> aClass) {
        return Modules.combine(new GuiceModule());
    }
}
