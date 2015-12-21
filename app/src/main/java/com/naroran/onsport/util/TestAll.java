package com.naroran.onsport.util;


import android.content.Context;

import com.naroran.onsport.R;

public class TestAll {
    private Context context;

    public TestAll(Context context){
        this.context = context;
    }

    public String getAppName(){
        return context.getString(R.string.app_name);
    }
}
