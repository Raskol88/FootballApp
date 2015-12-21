package com.naroran.onsport.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.naroran.onsport.R;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.data.TournamentItem;
import com.naroran.onsport.ui.PostImageView;

import java.util.List;

public class TournamentAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<TournamentItem> postItems;

    ImageLoader imageLoader  = AppController.getInstance().getImageLoader();


    public TournamentAdapter(Activity activity, List<TournamentItem> postItems) {
        this.activity = activity;
        this.postItems = postItems;
    }

    public void insert(TournamentItem item){
        postItems.add(item);
    }

    @Override
    public int getCount() {
        return postItems.size();
    }

    @Override
    public Object getItem(int location) {
        return postItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.tournament_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView number = (TextView) convertView.findViewById(R.id.number);
        TextView teamName = (TextView) convertView.findViewById(R.id.teamName);
        TextView scores = (TextView) convertView.findViewById(R.id.scores);
        TextView games = (TextView) convertView.findViewById(R.id.games);
        NetworkImageView teamImg = (NetworkImageView) convertView.findViewById(R.id.teamImg);
        TournamentItem item = postItems.get(position);
        number.setText(item.getNumber()+"");
        teamName.setText(item.getTeamName()+"");
        scores.setText(item.getScore()+"");
        games.setText(item.getGames()+"");

        teamImg.setImageUrl(item.getTeamImg(), imageLoader);


        return convertView;
    }

}
