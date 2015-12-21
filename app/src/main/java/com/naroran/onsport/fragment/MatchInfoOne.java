package com.naroran.onsport.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.naroran.onsport.MainActivity;
import com.naroran.onsport.R;
import com.naroran.onsport.activity.InfoMatch;
import com.naroran.onsport.activity.RGRactivity;
import com.naroran.onsport.adapter.NewsAdapter;
import com.naroran.onsport.adapter.TournamentAdapter;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.data.TournamentItem;
import com.naroran.onsport.util.CacheRequest;
import com.naroran.onsport.util.Json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MatchInfoOne extends Fragment {
    private ListView listView;
    private TournamentAdapter listAdapter;
    private List<TournamentItem> postItems;
    private String URL = "http://work.naroran.com/?type=table&name=";
    private String name;

    public MatchInfoOne(String name){
        this.name = name;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.match_info_1, container, false);

        listView = (ListView) inflate.findViewById(R.id.listview);
        listView.setDivider(null);
        postItems = new ArrayList<TournamentItem>();
        URL += name;
        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((InfoMatch) getActivity()).setProgressBarVisibility(View.VISIBLE);

        listAdapter = new TournamentAdapter(getActivity(), postItems);
        listView.setAdapter(listAdapter);

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL+"0");
        if (entry != null) {
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    Json.parseJsonTournament(postItems, new JSONObject(data));
                    listAdapter.notifyDataSetChanged();
                    ((InfoMatch) getActivity()).setProgressBarVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {

            CacheRequest cacheRequest = new CacheRequest(Request.Method.GET, URL, new Response.Listener<NetworkResponse>() {
                @Override
                public void onResponse(NetworkResponse response) {
                    try {
                        final String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                        if (jsonString != null) {
                            JSONObject jsonObject = new JSONObject(jsonString);
                            Json.parseJsonTournament(postItems, jsonObject);

                            listAdapter.notifyDataSetChanged();
                            ((InfoMatch) getActivity()).setProgressBarVisibility(View.GONE);
                        }
                    } catch (UnsupportedEncodingException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

            AppController.getInstance().addToRequestQueue(cacheRequest);
        }



    }
}