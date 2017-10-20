package com.laranerds.tests.listners;

import com.laranerds.tests.configuration.ModuleFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yuvaraj on 21/08/2017.
 */
public class InvokedMethodListener implements IInvokedMethodListener {

    private boolean scopeExit;

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        Class testClass = iInvokedMethod.getTestMethod().getInstance().getClass();
        Class superClass = testClass.getSuperclass();
        List<Method> methodList = new ArrayList<>();
        for(Class class1: new Class[]{testClass, superClass}) {
            methodList.addAll(Arrays.asList(class1.getDeclaredMethods()));
        }
        Method afterMethod = methodList.stream().filter(x->x.getDeclaredAnnotation(AfterMethod.class)!=null).findFirst().get();
        if(!iInvokedMethod.getTestMethod().getMethodName().equalsIgnoreCase("beforeTest")) {
            if(afterMethod != null) {
                ITestNGMethod testNGMethod = iInvokedMethod.getTestMethod();
                String methodName = testNGMethod.getMethodName();
                try {
                    if(testNGMethod.getRealClass().getDeclaredMethod(methodName).getDeclaredAnnotation(AfterMethod.class) != null) {
                        ModuleFactory.getTestMethodModule().testMethodScope.exitScope();
                        scopeExit = true;
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } else {
                ModuleFactory.getTestMethodModule().testMethodScope.exitScope();
                scopeExit = true;
            }
        }
    }
}
