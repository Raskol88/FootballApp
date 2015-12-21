package com.naroran.onsport.util;

import android.util.Log;

import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.data.ScoreItem;
import com.naroran.onsport.data.TournamentItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Json {

    public static void parseJsonNews(List<PostItem> items, JSONObject response) {

        try {
            JSONArray feedArray = response.getJSONArray("news");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                PostItem item = new PostItem();
                item.setName(feedObj.getString("title").replace("&quot;", ""));

                // Image might be null sometimes
                String image = feedObj.isNull("img") ? null : feedObj
                        .getString("img");
                item.setImge(image);
                item.setProfilePic(feedObj.getString("ico"));
                item.setTimeStamp(feedObj.getString("date"));
                item.setStatus(feedObj.getString("description"));

                // url might be null sometimes
                String feedUrl = feedObj.isNull("url") ? null : feedObj.getString("url");
                item.setUrl(feedUrl);

                items.add(item);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void parseJsonNewsNew(List<PostItem> items, JSONObject response) {
        List<PostItem> test = new ArrayList<PostItem>();
        parseJsonNews(test, response);
        for (PostItem item: test){
            boolean valid = true;
            for (PostItem item2: items){
                if (item.getImge().contains(item2.getImge())){
                    valid = false;
                }
            }
            if (valid){
                Log.d("ANDIS", "Item");
                items.add(item);
            }
        }

    }

    public static void parseJsonScore(List<ScoreItem> items, JSONObject response) {

        try {
            JSONArray feedArray = response.getJSONArray("livescore");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                ScoreItem item = new ScoreItem();
                item.setTeamOneImg(feedObj.getString("team_one_img"));
                item.setTeamTwoImg(feedObj.getString("team_two_img"));

                item.setTeamOneName(feedObj.getString("team_one_name"));
                item.setTeamTwoName(feedObj.getString("team_two_name"));
                item.setActive(feedObj.getBoolean("active"));
                item.setScore(feedObj.getString("score"));
                items.add(item);
            }



        } catch (JSONException e) {
            Log.d("ANDIS", "ERROR = ");

            e.printStackTrace();
        }
    }

    public static boolean parseJsonRGR(JSONObject response) {

        try {
            return response.getBoolean("answer");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void parseJsonTournament(List<TournamentItem> items, JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("table");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                TournamentItem item = new TournamentItem();

                item.setNubmer(Integer.parseInt(feedObj.getString("number")));

                item.setGames(Integer.parseInt(feedObj.getString("games")));
                item.setScore(Integer.parseInt(feedObj.getString("score")));
                item.setTeamName(feedObj.getString("name"));
                item.setTeamImg(feedObj.getString("img"));

                items.add(item);
            }



        } catch (JSONException e) {
            Log.d("ANDIS", "ERROR = ");

            e.printStackTrace();
        }
    }
}
