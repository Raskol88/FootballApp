package com.naroran.onsport.mytests;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.naroran.onsport.BaseInstrumentationTestCase;
import com.naroran.onsport.MainActivity;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

public class MockingTest extends BaseInstrumentationTestCase {

    public MockingTest(String pkg, Class activityClass) {
        super(pkg, activityClass);
    }

    public MockingTest(){
        super("com.naroran.onsport", MainActivity.class);
    }

    @Test
    public void testIntentShouldBeCreated() {
        Context context = Mockito.mock(Context.class);
        Intent intent = MainActivity.createQuery(context, "query", "value");
        assertNotNull(intent);
        Bundle extras = intent.getExtras();
        assertNotNull(extras);
        assertEquals("query", extras.getString("QUERY"));
        assertEquals("value", extras.getString("VALUE"));
    }
}