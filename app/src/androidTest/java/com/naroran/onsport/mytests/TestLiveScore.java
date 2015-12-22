package com.naroran.onsport.mytests;

import android.test.InstrumentationTestCase;

import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.data.ScoreItem;
import com.naroran.onsport.util.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



import android.test.InstrumentationTestCase;
import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.util.Json;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestLiveScore extends InstrumentationTestCase {

    private JSONObject jsonObj;

    @Override
    protected  void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void  testServerNews(){
        jsonObj = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray feedArray = new JSONArray();
        try {
            data.put("time", "22:00");
            data.put("team_one_name", "Manchester");
            data.put("team_one_img", "http:\\/\\/s.ill.in.ua\\/i\\/football\\/team\\/logo_sm\\/0x20\\/25.png");
            data.put("team_two_name", "Liverpool");
            data.put("team_two_img", "http:\\/\\/s.ill.in.ua\\/i\\/football\\/team\\/logo_sm\\/0x20\\/25.png");
            data.put("active", "false");
            data.put("score", "team_two_img");
            feedArray.put(0, data);
            jsonObj.put("livescore", feedArray);
        } catch (JSONException e) {
            assertTrue(false);
            e.printStackTrace();
        }

        Json json = new Json();
        List<ScoreItem> postItems = new ArrayList<>();
        json.parseJsonScore(postItems, jsonObj);
        if (postItems.size() == 0){
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
    }
}