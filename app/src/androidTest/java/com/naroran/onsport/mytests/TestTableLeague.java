package com.naroran.onsport.mytests;

import android.test.InstrumentationTestCase;

import com.naroran.onsport.data.ScoreItem;
import com.naroran.onsport.data.TournamentItem;
import com.naroran.onsport.util.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTableLeague extends InstrumentationTestCase {

    private JSONObject jsonObj;

    @Override
    protected  void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void  testTableLeague(){
        jsonObj = new JSONObject();
        JSONArray feedArray = new JSONArray();
        JSONObject data = new JSONObject();

        try {
            data.put("number", "1");
            data.put("img", "http://s.ill.in.ua/i/football/team/logo/0x20/478_logo.png");
            data.put("name", "Manchester");
            data.put("games", "10");
            data.put("score", "38");
            feedArray.put(data);
            jsonObj.put("table", feedArray);
        } catch (JSONException e) {
            assertTrue(false);
            e.printStackTrace();
        }

        Json json = new Json();
        List<TournamentItem> items = new ArrayList<>();
        json.parseJsonTournament(items, jsonObj);
        System.out.println("Suze = "+items.size());
        try {
            if (items.get(0).getTeamName().equals(data.getString("name"))){
                assertTrue(true);
            }
            else{
                assertTrue(false);
            }
        } catch (JSONException e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
    }
}