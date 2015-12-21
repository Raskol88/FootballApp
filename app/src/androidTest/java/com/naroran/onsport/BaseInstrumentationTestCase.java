package com.naroran.onsport;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public abstract class BaseInstrumentationTestCase<T extends Activity> extends ActivityInstrumentationTestCase2<T> {


    public BaseInstrumentationTestCase(String pkg, Class<T> activityClass) {
        super(pkg, activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty( "dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath() );

    }
}