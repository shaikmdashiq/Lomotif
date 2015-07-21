package com.artqueen.lomotif.adapters;

import android.graphics.Bitmap;

/**
 * Created by shaikmdashiq on 21/7/15.
 */
public class AlbumDB {

    private String albumName;
    private String imageUrl;


    public AlbumDB(String albumName, String imageUrl, Bitmap albumPic) {
        this.albumName = albumName;
        this.imageUrl = imageUrl;
    }

    public AlbumDB() {

    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
