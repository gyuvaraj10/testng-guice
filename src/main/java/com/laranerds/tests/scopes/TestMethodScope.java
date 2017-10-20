package com.laranerds.tests.scopes;

import com.google.inject.*;
import com.laranerds.tests.configuration.ModuleFactory;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestMethodScope implements Scope {

    private ThreadLocal<Map<Key<?>, Object>> threadLocal = new ThreadLocal<>();

    public TestMethodScope() {
        threadLocal.set(new HashMap<Key<?>, Object>());
    }
    @Inject
    Provider<WebDriver> provider;

    public void enterScope() {
        threadLocal.set(new HashMap<Key<?>, Object>());
    }

    public void exitScope() {
        threadLocal.remove();
        enterScope();
    }

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
        return new Provider<T>() {
            public T get() {
                T current = (T) threadLocal.get().get(key);
                if (current == null && !threadLocal.get().containsKey(key)) {
                    current = unscoped.get();
                    if (Scopes.isCircularProxy(current)) {
                        return current;
                    }
                    threadLocal.get().put(key, current);
                }
                return current;
            }
        };
    }
}
