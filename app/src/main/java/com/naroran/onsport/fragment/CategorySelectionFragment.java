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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.naroran.onsport.MainActivity;
import com.naroran.onsport.R;
import com.naroran.onsport.adapter.NewsAdapter;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.util.CacheRequest;
import com.naroran.onsport.util.Json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategorySelectionFragment extends Fragment implements AbsListView.OnScrollListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final int REQUEST_CATEGORY = 0x2300;
    private ListView listView;
    private NewsAdapter listAdapter;
    private List<PostItem> postItems;
    private static final String TAG = MainActivity.class.getSimpleName();

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Adapter mAdapter;
    private String[] mCatNames;
    private int offset = 0;

    public static CategorySelectionFragment newInstance() {
        return new CategorySelectionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_news, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.activity_main_swipe_refresh_layout);
        mCatNames = getResources().getStringArray(R.array.cat_names);
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor("#000000"));
        mSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#233781"), Color.parseColor("#23814b"), Color.parseColor("#812325"));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        listView = (ListView) inflate.findViewById(R.id.activity_main_listview);
        listView.setDivider(null);
        postItems = new ArrayList<PostItem>();

        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).setProgressBarVisibility(View.VISIBLE);

        listAdapter = new NewsAdapter(getActivity(), postItems);
        listView.setAdapter(listAdapter);

        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this); //
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(AppController.getInstance().URL_NEWS+"0");
        if (entry != null) {
            Log.d("ANDIS", "CATCH");
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    Json.parseJsonNews(postItems, new JSONObject(data));
                    listAdapter.notifyDataSetChanged();
                    ((MainActivity) getActivity()).setProgressBarVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {

            CacheRequest cacheRequest = new CacheRequest(Request.Method.GET, AppController.getInstance().URL_NEWS+"0", new Response.Listener<NetworkResponse>() {
                @Override
                public void onResponse(NetworkResponse response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    try {
                        final String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                        if (jsonString != null) {
                            Log.d("ANDIS", "Start Transfer");
                            JSONObject jsonObject = new JSONObject(jsonString);

                            Json.parseJsonNews(postItems, jsonObject);
                            listAdapter.notifyDataSetChanged();
                            ((MainActivity) getActivity()).setProgressBarVisibility(View.GONE);
                        }
                    } catch (UnsupportedEncodingException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            AppController.getInstance().addToRequestQueue(cacheRequest);
        }

    }

    private void refreshContent(){
        hideRefresh();
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

        boolean loadMore = firstVisible + visibleCount >= totalCount-1;


        if(loadMore) {

            ListAdapter adapter = absListView.getAdapter();
            if (adapter instanceof NewsAdapter) {
                NewsAdapter sta = (NewsAdapter) adapter;
                if (totalCount>0 && !download) {
                    offset = totalCount;
                    download = true;
                    mSwipeRefreshLayout.setRefreshing(true);
                    JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, AppController.getInstance().URL_NEWS+offset, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            VolleyLog.d(TAG, "Response: " + response.toString());
                            if (response != null) {
                                Json.parseJsonNews(postItems, response);
                                listAdapter.notifyDataSetChanged();
                                hideRefresh();
                            }
                            else{
                                Toast.makeText(getActivity(), "No News", Toast.LENGTH_LONG).show();
                            }
                            download = false;
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d(TAG, "Error: " + error.getMessage());
                        }
                    });
                    AppController.getInstance().addToRequestQueue(jsonReq);

                    sta.notifyDataSetChanged();
                }
            }
        }
    }

}
