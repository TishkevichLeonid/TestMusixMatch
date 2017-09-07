package com.example.android.testmusixmatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class Artist {

    @SerializedName("artist_id")
    @Expose
    private Integer artistId;
    @SerializedName("artist_mbid")
    @Expose
    private String artistMbid;
    @SerializedName("artist_name")
    @Expose
    private String artistName;
    @SerializedName("artist_alias_list")
    @Expose
    private List<Object> artistAliasList = null;
    @SerializedName("artist_rating")
    @Expose
    private Integer artistRating;
    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistMbid() {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid) {
        this.artistMbid = artistMbid;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Object> getArtistAliasList() {
        return artistAliasList;
    }

    public void setArtistAliasList(List<Object> artistAliasList) {
        this.artistAliasList = artistAliasList;
    }

    public Integer getArtistRating() {
        return artistRating;
    }

    public void setArtistRating(Integer artistRating) {
        this.artistRating = artistRating;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}


