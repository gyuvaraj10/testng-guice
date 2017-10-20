package com.laranerds.tests.configuration;

import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Yuvaraj on 24/05/2017.
 */
public class PageListner implements TypeListener {

    @Override
    public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
        Annotation[] annotations = typeLiteral.getRawType().getDeclaredAnnotations();
        Field[] fields = typeLiteral.getRawType().getDeclaredFields();
        if(fields.length > 0 ) {
            for(Field field: fields) {
                if (field.getType().isAssignableFrom(WebElement.class)) {
                    typeEncounter.register(new PageFactoryInjectionListner(typeEncounter.getProvider(WebDriver.class)));
                    break;
                }
            }
        }
    }
}
