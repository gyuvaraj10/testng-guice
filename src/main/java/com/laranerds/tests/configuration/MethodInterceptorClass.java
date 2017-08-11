package com.laranerds.tests.configuration;

import com.laranerds.tests.annotations.Page;
import com.laranerds.tests.annotations.Report;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * Created by Yuvaraj on 11/08/2017.
 */
public class MethodInterceptorClass implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String value = "";
        Page page = methodInvocation.getMethod().getDeclaringClass().getDeclaredAnnotation(Page.class);
        if (page != null){
           Report report = methodInvocation.getMethod().getDeclaredAnnotation(Report.class);
            if(report != null) {
                value = report.value();
                System.out.println(value);
            }
        }
        return methodInvocation.proceed();
    }
}
