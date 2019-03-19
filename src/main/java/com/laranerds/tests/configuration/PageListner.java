package com.laranerds.tests.configuration;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import com.laranerds.tests.annotations.Mobile;
import com.laranerds.tests.annotations.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.Option;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yuvaraj on 24/05/2017.
 */
public class PageListner implements TypeListener {

    @Override
    public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
        List<Annotation> annotationList = Arrays.asList(typeLiteral.getRawType().getDeclaredAnnotations());
        Field[] fields = typeLiteral.getRawType().getDeclaredFields();
        if(fields.length > 0 ) {
            for(Field field: fields) {
                if (field.getType().isAssignableFrom(WebElement.class)) {
                    Optional<Annotation> mobileAnnotation = annotationList.stream().filter(x->x.annotationType().getName().contains("Mobile")).findFirst();
                    Optional<Annotation> webAnnotation = annotationList.stream().filter(x->x.annotationType().getName().contains("Web")).findFirst();
                    if(webAnnotation.isPresent()) {
                        typeEncounter.register(new PageFactoryInjectionListner(typeEncounter.getProvider(Key.get(WebDriver.class, Web.class))));
                    } else if(mobileAnnotation.isPresent()) {
                        typeEncounter.register(new PageFactoryInjectionListner(typeEncounter.getProvider(Key.get(WebDriver.class, Mobile.class))));
                    }
                    break;
                }
            }
        }



    }
}
