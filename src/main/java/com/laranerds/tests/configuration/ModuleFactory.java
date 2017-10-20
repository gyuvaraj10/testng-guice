package com.laranerds.tests.configuration;

import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.laranerds.tests.scopes.TestMethodModule;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

/**
 * Created by Yuvaraj on 23/05/2017.
 */
public class ModuleFactory implements IModuleFactory {

    private static TestMethodModule testMethodModule;
    static Module module;
    static Injector injector;

    public ModuleFactory() {
    }

    public Module createModule(ITestContext iTestContext, Class<?> aClass) {
        testMethodModule = new TestMethodModule();
        module =  Modules.combine(new GuiceModule(), testMethodModule);
        return module;
    }

    public static TestMethodModule getTestMethodModule() {
        return testMethodModule;
    }

    public static Injector getInjector() {
        if(injector == null) {
            injector = Guice.createInjector(module);
        }
        return injector;
    }
}
