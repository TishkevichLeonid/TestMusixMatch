package com.example.android.testmusixmatch.modelArtist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class ArtistList {

    @SerializedName("artist")
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
