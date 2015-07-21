package com.artqueen.lomotif.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.util.Log;

import com.artqueen.lomotif.utilities.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaikmdashiq on 21/7/15.
 */
public class GetAlbum {

    //reading JSON
    public static List<AlbumDB> getAlbumList(Context context)
    {
        List<AlbumDB> list = new ArrayList<AlbumDB>();

        try {
            URL url = new URL("http://itunes.apple.com/au/rss/topsongs/limit=10/json");
            URLConnection connection = url.openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject itunesJsonObject = new JSONObject(builder.toString());

            JSONObject feedJsonOject = itunesJsonObject.getJSONObject("feed");
            JSONArray arrayJsonObject = feedJsonOject.getJSONArray("entry");

            for(int i = 0 ; i < arrayJsonObject.length() ; i++){
                String albumName = arrayJsonObject.getJSONObject(i).getJSONObject("title").getString("label");

                String UrlImage = arrayJsonObject.getJSONObject(i).getJSONArray("im:image").getJSONObject(0).getString("label");

                AlbumDB album = new AlbumDB();
                album.setAlbumName(albumName);
                URL imageUrl = new URL(UrlImage);
                album.setAlbumPic(BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream()));
                list.add(album);

            }
        } catch (Exception e) {
        }
        return(list);
    }

}
