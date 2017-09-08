package com.example.android.testmusixmatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonidtiskevic on 08.09.17.
 */

public class Body {

    @SerializedName("artist_list")
    @Expose
    private List<ArtistList> artistList = null;

    public List<ArtistList> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<ArtistList> artistList) {
        this.artistList = artistList;
    }
}

