package com.naroran.onsport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.naroran.onsport.activity.InfoMatch;
import com.naroran.onsport.activity.RGRactivity;
import com.naroran.onsport.app.AppController;
import com.naroran.onsport.fragment.CategorySelectionFragment;
import com.naroran.onsport.fragment.LiveScoreFragment;
import com.naroran.onsport.framework.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type"); //if it's a string you stored.
        if (type == "nav_news"){
            attachNews();
        }
        else if(type == "nav_livescore"){
            attachLiveScore();
        }
        else if (savedInstanceState == null) {
            attachNews();
           // attachCategoryGridFragment();
        }
        System.setProperty("dexmaker.dexcache", getBaseContext().getCacheDir().getPath());

    }


    private void attachNews() {
        setToolbarTitle("Новости");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragment = supportFragmentManager.findFragmentById(R.id.news_container);
        if (!(fragment instanceof CategorySelectionFragment)) {
            fragment = CategorySelectionFragment.newInstance();
        }
        supportFragmentManager.beginTransaction().replace(R.id.news_container, fragment).commit();
    }

    private void attachLiveScore(){
        setToolbarTitle(getResources().getString(R.string.live_score_title));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragment = supportFragmentManager.findFragmentById(R.id.news_container);
        if (!(fragment instanceof LiveScoreFragment)) {
            fragment = LiveScoreFragment.newInstance();
        }
        supportFragmentManager.beginTransaction() .replace(R.id.news_container, fragment).commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            attachNews();
        } else if (id == R.id.nav_livescore) {
            attachLiveScore();
        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(this, InfoMatch.class);
            myIntent.putExtra("type", "nav_livescore"); //Optional parameters
            this.startActivity(myIntent);
        } else if (id == R.id.nav_manage){
            Intent myIntent = new Intent(this, RGRactivity.class);
            this.startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static Intent createQuery(Context context, String query, String value) {
        // Reuse MainActivity for simplification
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("QUERY", query);
        i.putExtra("VALUE", value);
        return i;
    }

}
