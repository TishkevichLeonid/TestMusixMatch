package com.example.android.testmusixmatch.modelArtist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class Artist {

    @SerializedName("artist_id")

    private Integer artistId;
    @SerializedName("artist_mbid")
    private String artistMbid;
    @SerializedName("artist_name")
    private String artistName;
    @SerializedName("artist_name_translation_list")
    private List<Object> artistNameTranslationList = null;
    @SerializedName("artist_comment")
    @Expose
    private String artistComment;
    @SerializedName("artist_country")
    @Expose
    private String artistCountry;
    @SerializedName("artist_rating")
    @Expose
    private Integer artistRating;
    @SerializedName("artist_twitter_url")
    @Expose
    private String artistTwitterUrl;
    @SerializedName("artist_vanity_id")
    @Expose
    private String artistVanityId;
    @SerializedName("artist_edit_url")
    @Expose
    private String artistEditUrl;
    @SerializedName("artist_share_url")
    @Expose
    private String artistShareUrl;
    @SerializedName("restricted")
    @Expose
    private Integer restricted;
    @SerializedName("managed")
    @Expose
    private Integer managed;
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

    public List<Object> getArtistNameTranslationList() {
        return artistNameTranslationList;
    }

    public void setArtistNameTranslationList(List<Object> artistNameTranslationList) {
        this.artistNameTranslationList = artistNameTranslationList;
    }

    public String getArtistComment() {
        return artistComment;
    }

    public void setArtistComment(String artistComment) {
        this.artistComment = artistComment;
    }

    public String getArtistCountry() {
        return artistCountry;
    }

    public void setArtistCountry(String artistCountry) {
        this.artistCountry = artistCountry;
    }

    public Integer getArtistRating() {
        return artistRating;
    }

    public void setArtistRating(Integer artistRating) {
        this.artistRating = artistRating;
    }

    public String getArtistTwitterUrl() {
        return artistTwitterUrl;
    }

    public void setArtistTwitterUrl(String artistTwitterUrl) {
        this.artistTwitterUrl = artistTwitterUrl;
    }

    public String getArtistVanityId() {
        return artistVanityId;
    }

    public void setArtistVanityId(String artistVanityId) {
        this.artistVanityId = artistVanityId;
    }

    public String getArtistEditUrl() {
        return artistEditUrl;
    }

    public void setArtistEditUrl(String artistEditUrl) {
        this.artistEditUrl = artistEditUrl;
    }

    public String getArtistShareUrl() {
        return artistShareUrl;
    }

    public void setArtistShareUrl(String artistShareUrl) {
        this.artistShareUrl = artistShareUrl;
    }

    public Integer getRestricted() {
        return restricted;
    }

    public void setRestricted(Integer restricted) {
        this.restricted = restricted;
    }

    public Integer getManaged() {
        return managed;
    }

    public void setManaged(Integer managed) {
        this.managed = managed;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}


