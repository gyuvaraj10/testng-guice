package com.tests;

import com.google.inject.Inject;
import com.laranerds.tests.pages.SampleDepe;
import org.testng.annotations.Test;

public class TestClass2 extends TestClass {

    @Inject
    SampleDepe sampleDepe;

    @Test
    public void testmethod1() throws Exception {
        sampleDepe.displayMethod();
        sampleDepe.displayMethod2();
        sampleDepe.displayMethod3();
    }

    @Test
    public void testmethod3() throws Exception {
        sampleDepe.displayMethod();
        sampleDepe.displayMethod2();
        sampleDepe.displayMethod3();
    }
}
