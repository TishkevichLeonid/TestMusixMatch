package com.example.android.testmusixmatch.modelTrack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonidtiskevic on 09.09.17.
 */

public class Body {

    @SerializedName("track_list")
    @Expose
    private List<TrackList> trackList = null;

    public List<TrackList> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<TrackList> trackList) {
        this.trackList = trackList;
    }

}
