package com.naroran.onsport.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.naroran.onsport.R;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.data.ScoreItem;
import com.naroran.onsport.ui.PostImageView;

import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ScoreItem> ScoreItems;
    ImageLoader imageLoader  = AppController.getInstance().getImageLoader();


    public ScoreAdapter(Activity activity, List<ScoreItem> ScoreItems) {
        this.activity = activity;
        this.ScoreItems = ScoreItems;
    }

    public void insert(ScoreItem item){
        ScoreItems.add(item);
    }

    @Override
    public int getCount() {
        return ScoreItems.size();
    }

    @Override
    public Object getItem(int location) {
        return ScoreItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.live_score, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView teamOneName = (TextView) convertView.findViewById(R.id.teamOneName);
        TextView teamTwoName = (TextView) convertView.findViewById(R.id.teamTwoName);
        TextView score = (TextView) convertView.findViewById(R.id.score);
        NetworkImageView teamOneImg = (NetworkImageView) convertView.findViewById(R.id.teamOneImg);
        NetworkImageView teamTwoImg = (NetworkImageView) convertView.findViewById(R.id.teamTwoImg);

        ScoreItem item = ScoreItems.get(position);
        String teamOneNameS = item.getTeamOneName();
        String teamTwoNameS = item.getTeamTwoName();
        if (teamOneNameS.contains(" ")){
            teamOneNameS  = teamOneNameS.charAt(0)+""+teamOneNameS.charAt(teamOneNameS.indexOf(" ")+1);
        }
        if (teamTwoNameS.contains(" ")){
            teamTwoNameS  = teamTwoNameS.charAt(0)+""+teamTwoNameS.charAt(teamTwoNameS.indexOf(" ")+1);
        }
        teamOneName.setText(teamOneNameS);
        teamTwoName.setText(teamTwoNameS);
        score.setText(item.getScore());
        if (!item.isActive()){
            RelativeLayout scoreLayout = (RelativeLayout) convertView.findViewById(R.id.score_layout);
            scoreLayout.setBackgroundColor(activity.getResources().getColor(R.color.onsport_primary_dark));
            score.setTextColor(activity.getResources().getColor(R.color.text_dark));
            Log.d("ANDIS", "NOACTIVE");
        }
        else{
            RelativeLayout scoreLayout = (RelativeLayout) convertView.findViewById(R.id.score_layout);
            scoreLayout.setBackgroundColor(activity.getResources().getColor(R.color.onsport_blank));
            score.setTextColor(activity.getResources().getColor(R.color.theme_blue_primary));
            Log.d("ANDIS", "ACTIVE");

        }
        teamOneImg.setImageUrl(item.getTeamOneImg(), imageLoader);
        teamTwoImg.setImageUrl(item.getTeamTwoImg(), imageLoader);


        return convertView;
    }

}
