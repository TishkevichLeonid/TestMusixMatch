package com.example.android.testmusixmatch.modelArtist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * json покажи
 */

public class Body {

    @SerializedName("artist_list")
    private List<ArtistList> artistList = null;

    public List<ArtistList> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<ArtistList> artistList) {
        this.artistList = artistList;
    }
}



