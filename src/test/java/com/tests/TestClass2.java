package com.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.laranerds.tests.pages.SampleDepe;
import com.laranerds.tests.pages.SampleDepeWeb;
import org.testng.annotations.Test;

public class TestClass2 extends TestClass {

    @Inject
    Provider<SampleDepe> sampleDepe;

    @Inject
    Provider<SampleDepeWeb> sampleDepe2;

    @Test
    public void testmethod1() throws Exception {
        sampleDepe.get().displayMethod();
        sampleDepe2.get().displayMethod();
        sampleDepe.get().displayMethod2();
        sampleDepe.get().displayMethod3();

    }

    @Test
    public void testmethod3() throws Exception {
        sampleDepe.get().displayMethod();
        sampleDepe.get().displayMethod2();
        sampleDepe.get().displayMethod3();
    }
}
