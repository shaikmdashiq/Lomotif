package com.artqueen.lomotif.adapters;

/**
 * Created by shaikmdashiq on 21/7/15.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.artqueen.lomotif.R;

import java.util.ArrayList;
import java.util.List;


public class AudioListAdapter extends ArrayAdapter<AlbumDB> {

    private List<AlbumDB> items;
    private Context context;
    TextView albumNameTV;
    ImageView albumIV;

    public AudioListAdapter(Context context, int resource, List<AlbumDB> items) {
        super(context, resource, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.listview_item, null);
        AlbumDB p = items.get(position);

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/champagne.ttf");

        if (p != null) {
            albumNameTV = (TextView) v.findViewById(R.id.albumNameTV);
            albumIV = (ImageView) v.findViewById(R.id.albumIV);

            albumNameTV.setTypeface(typeFace);
            albumNameTV.setText(p.getAlbumName());
            albumIV.setImageBitmap(p.getAlbumPic());

        }
        return v;
    }
}
