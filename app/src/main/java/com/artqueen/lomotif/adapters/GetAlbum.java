package com.artqueen.lomotif.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import com.artqueen.lomotif.utilities.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaikmdashiq on 21/7/15.
 */
public class GetAlbum {

    //reading JSON
    public static List<AlbumDB> getAlbumList(Context context)
    {

        String url = "urlHere";

        List<AlbumDB> list = new ArrayList<AlbumDB>();
        //getting an array from URL
        JSONArray a = JsonParser.getJSONArrayFromUrl(url);

        try {
            for (int i =0; i<a.length(); i++) {
                //getting JSON object
                JSONObject obj = a.getJSONObject(i);
                //adding new Objects to list
                String fileURL = obj.getString("file");
                if (!fileURL.equals("null")) {
                    AlbumDB album = new AlbumDB();

                    album.setAlbumName(obj.getString(""));
                    album.setArtistName(obj.getString(""));
                    URL imageUrl = new URL(obj.getString(""));
                    album.setAlbumPic(BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream()));

                    list.add(album);
                }
            }
            return list;

        } catch (Exception e) {
        }
        return(list);
    }

}
