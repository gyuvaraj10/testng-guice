package com.laranerds.tests.scopes;

import com.google.common.collect.Maps;
import com.google.inject.*;

import java.util.HashMap;
import java.util.Map;

public class TestMethodScope implements Scope {

    private Map<Key<?>, Object> values = new HashMap<>();

    public void enter() {
//        values = new HashMap<>();
    }

    public void exit() {
        values.clear();
    }

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
        return new Provider<T>() {
            public T get() {
                T current = (T) values.get(key);
                if (current == null && !values.containsKey(key)) {
                    current = unscoped.get();

                    // don't remember proxies; these exist only to serve circular dependencies
                    if (Scopes.isCircularProxy(current)) {
                        return current;
                    }

                    values.put(key, current);
                }
                return current;
            }
        };
    }
}
