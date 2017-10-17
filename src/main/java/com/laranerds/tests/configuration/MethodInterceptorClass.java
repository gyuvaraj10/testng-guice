package com.laranerds.tests.configuration;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * Created by Yuvaraj on 11/08/2017.
 */
public class MethodInterceptorClass implements MethodInterceptor {

    @Inject
    Injector injector;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String value = "";
        Page page = methodInvocation.getMethod().getDeclaringClass().getDeclaredAnnotation(Page.class);
        if (page != null ) {
            Report report = methodInvocation.getMethod().getDeclaredAnnotation(Report.class);
            if(report != null) {
                value = report.value();
                try {
                    methodInvocation.proceed();
                    System.out.println("Success " +value);
                } catch (Exception ex) {
                    System.out.println("Failed " + value + "due to" +ex.getMessage());
                }
            }
            return value;

        } else{
            return methodInvocation.proceed();
        }
    }
}
