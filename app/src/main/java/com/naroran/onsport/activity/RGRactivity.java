package com.naroran.onsport.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.naroran.onsport.R;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.framework.BaseActivity;
import com.naroran.onsport.util.Json;

import org.json.JSONObject;

import java.util.ArrayList;

public class RGRactivity extends BaseActivity{

    private String URL = "http://work.naroran.com?type=error";
    private  GraphView graph;
    private LineGraphSeries<DataPoint> series;
    private  ArrayList<Integer> datas;
    private  TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgr);
        setToolbarTitle("RGR test");
         graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>(new DataPoint[] {new DataPoint(0, 0)});
        graph.addSeries(series);
        datas  = new ArrayList<Integer>();
        text  = (TextView) findViewById(R.id.success);
        text.setText("");
        parseData();
    }

    private void parseData(){
        Log.d("ANDIS", "ParseData");
        final JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("ANDIS", response.toString());

                if (response != null) {
                    listener(Json.parseJsonRGR(response));
                }
                else{
                    Toast.makeText(getBaseContext(), "Error while loading", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ANDIS", "Error");

            }
        });

        new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    AppController.getInstance().addToRequestQueue(jsonReq);
                }
            }, time);
    }

    private int time = 1;

    public void listener(boolean valid){
        if (valid){
            Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
            text.setText("Success");
            datas.add(time/1000);
            setProgressBarVisibility(View.GONE);
        }
        else{
            Toast.makeText(getBaseContext(), "Error, time = "+time/1000, Toast.LENGTH_LONG).show();
            datas.add(time/1000);
            if (time == 1) {
                time = 5000;
            }
            else{
                time += time;
            }
            parseData();
        }

        int count = 0;
        DataPoint[] data_arr = new DataPoint[datas.size()];
        for (Integer time : datas){
            data_arr[count++] = new DataPoint(count, time);
        }
        series.resetData(data_arr);
    }
}
