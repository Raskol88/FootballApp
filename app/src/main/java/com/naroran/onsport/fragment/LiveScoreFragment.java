/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naroran.onsport.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.naroran.onsport.MainActivity;
import com.naroran.onsport.R;
import com.naroran.onsport.adapter.NewsAdapter;
import com.naroran.onsport.adapter.ScoreAdapter;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.data.ScoreItem;
import com.naroran.onsport.util.Json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LiveScoreFragment extends Fragment implements AbsListView.OnScrollListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final int REQUEST_CATEGORY = 0x2300;
    private ListView listView;
    private ScoreAdapter listAdapter;
    private List<ScoreItem> postItems;
    private static final String TAG = MainActivity.class.getSimpleName();

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Adapter mAdapter;
    private String[] mCatNames;
    private int offset = 0;

    public static LiveScoreFragment newInstance() {
        return new LiveScoreFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_scores, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.swipe_refresh_layout);
        mCatNames = getResources().getStringArray(R.array.cat_names);
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor("#000000"));
        mSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#233781"), Color.parseColor("#23814b"), Color.parseColor("#812325"));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        listView = (ListView) inflate.findViewById(R.id.listview);
        listView.setDivider(null);
        postItems = new ArrayList<ScoreItem>();

        listAdapter = new ScoreAdapter(getActivity(), postItems);
        listView.setAdapter(listAdapter);

        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
       // listView.setOnItemLongClickListener(this); //

        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, AppController.getInstance().URL_LIVE_SCORE, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    if (response != null) {
                        Json.parseJsonScore(postItems, response);
                        listAdapter.notifyDataSetChanged();
                        ((MainActivity) getActivity()).setProgressBarVisibility(View.GONE);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

        AppController.getInstance().addToRequestQueue(jsonReq);
        ((MainActivity) getActivity()).setProgressBarVisibility(View.VISIBLE);

        return inflate;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void refreshContent(){
        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, AppController.getInstance().URL_LIVE_SCORE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                VolleyLog.d(TAG, "Response: " + response.toString());
                if (response != null) {
                    postItems.clear();
                    Json.parseJsonScore(postItems, response);
                    if (postItems.size() != 0)
                        listAdapter.notifyDataSetChanged();
                    ((MainActivity) getActivity()).setProgressBarVisibility(View.GONE);
                }
                else{
                    Toast.makeText(getActivity(), "No Live Score", Toast.LENGTH_LONG).show();
                }

                download = false;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                ((MainActivity) getActivity()).setProgressBarVisibility(View.GONE);
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        hideRefresh();
        AppController.getInstance().addToRequestQueue(jsonReq);

    }

    private void hideRefresh(){
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }



    @Override
    public void onResume() {
        getActivity().supportStartPostponedEnterTransition();
        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ScoreItem s = (ScoreItem) ((ScoreAdapter) parent.getAdapter()).getItem(position);
        Log.d("ANDIS", "CLICK = "+s.getScore());

    }

    public boolean onItemLongClick(AdapterView<?> parent, View view,  int position, long id) {
        return true; // We've consumed the long click
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        // nothing to do for us
    }

    private boolean download = false;

    @SuppressWarnings("unchecked")
    public void onScroll(AbsListView absListView, int firstVisible, int visibleCount, int totalCount) {

    }

}
