package com.naroran.onsport;

import android.content.Context;

import com.naroran.onsport.util.TestAll;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {
        when(mMockContext.getString(R.string.app_name)).thenReturn(FAKE_STRING);
        TestAll myObjectUnderTest = new TestAll(mMockContext);
        String result = myObjectUnderTest.getAppName();
        assertThat(result, is(FAKE_STRING));
    }
}