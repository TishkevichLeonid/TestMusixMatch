package com.example.android.testmusixmatch.modelTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonidtiskevic on 09.09.17.
 * Singleton класс
 */

public class TrackBox {
    public static TrackBox sTrackBox;

    private List<Track> mTrackList;

    public static TrackBox get(){
        if (sTrackBox == null){
            sTrackBox = new TrackBox();
        }
        return sTrackBox;
    }

    public List<Track> getTrackList() {
        return mTrackList;
    }

    public void setTrackList(List<Track> trackList) {
        mTrackList = trackList;
    }

    private TrackBox(){
        mTrackList = new ArrayList<>();
    }

    public Track getTrack(int id){
        for (Track track: mTrackList){
            if (track.getArtistId().equals(id)){
                return track;
            }
        }
        return null;
    }

}
