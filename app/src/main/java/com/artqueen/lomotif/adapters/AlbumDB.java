package com.artqueen.lomotif.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by shaikmdashiq on 21/7/15.
 */
public class AlbumDB {

    private String albumName;
    private String artistName;
    private Bitmap albumPic;


    public AlbumDB(String albumName, String artistName, Bitmap albumPic) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.albumPic = albumPic;
    }

    public AlbumDB() {

    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Bitmap getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(Bitmap albumPic) {
        this.albumPic = albumPic;
    }


}
