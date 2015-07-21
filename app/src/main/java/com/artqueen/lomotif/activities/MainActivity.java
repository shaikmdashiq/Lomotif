package com.artqueen.lomotif.activities;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.artqueen.lomotif.R;
import com.artqueen.lomotif.adapters.AlbumDB;
import com.artqueen.lomotif.adapters.AudioListAdapter;
import com.artqueen.lomotif.adapters.GetAlbum;

import java.util.List;


public class MainActivity extends Activity {

    ListView audioLV;
    AudioListAdapter audioAdapter;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        audioLV = (ListView) findViewById(R.id.audioLV);

        new AsyncTask<Void, Void, List<AlbumDB>>() {
            @Override
            protected List<AlbumDB> doInBackground(Void... params) {
                return GetAlbum.getAlbumList(mContext);
            }

            @Override
            protected void onPostExecute(List<AlbumDB> result)
            {
                AudioListAdapter adapter = new AudioListAdapter(mContext,R.layout.listview_item, result);
                audioLV.setAdapter(adapter);

            }
        }.execute();



    }




}
