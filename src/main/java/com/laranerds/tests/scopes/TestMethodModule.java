package com.laranerds.tests.scopes;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.laranerds.tests.scopes.TestMethodScope;
import com.laranerds.tests.scopes.TestMethodScoped;

/**
 * Created by Yuvaraj on 20/08/2017.
 */
public class TestMethodModule extends AbstractModule {

    public TestMethodScope testMethodScope;

    public TestMethodModule() {
        testMethodScope = new TestMethodScope();
    }

    @Override
    protected void configure() {
        bindScope(TestMethodScoped.class, testMethodScope);
    }
}
