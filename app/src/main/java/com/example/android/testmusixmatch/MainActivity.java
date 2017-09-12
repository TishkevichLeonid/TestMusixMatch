package com.example.android.testmusixmatch;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;

import com.example.android.testmusixmatch.modelArtist.Artist;
import com.example.android.testmusixmatch.modelArtist.ArtistList;
import com.example.android.testmusixmatch.modelArtist.MessageWrap;
import com.example.android.testmusixmatch.modelTrack.MessageWrapTrack;
import com.example.android.testmusixmatch.modelTrack.Track;
import com.example.android.testmusixmatch.modelTrack.TrackBox;
import com.example.android.testmusixmatch.modelTrack.TrackList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test_log";
    private static final String KEY = "e9693a724b2cff4dfde5fc39f9bc85a6";
    public static final String RUS = "ru";
    public static final String ITALY = "it";
    public static final String KEY_RECYCLER = "recycler";
    public static final int COUNT_ARTIST = 100;
    public static final int COUNT_TRACK = 100;

    private RecyclerView mRecyclerView;
    private List<Artist> mArtistList;
    private TrackBox mTrackBox;
    private List<Track> mTrackList;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#FF4081\">" + getString(R.string.app_name) + "</font>")));

        mArtistList = new ArrayList<>();
        mTrackList = new ArrayList<>();

        receiveTracks();
        mTrackBox = TrackBox.get();
        mTrackBox.setTrackList(mTrackList);

        mRecyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        receiveArtists();
        updateUi();
    }

    private void receiveTracks(){
        App.getApi().getDataTrack(KEY, 1, COUNT_TRACK, "ru").enqueue(new Callback<MessageWrapTrack>() {
            @Override
            public void onResponse(Call<MessageWrapTrack> call, Response<MessageWrapTrack> response) {
                try {
                    for(TrackList all : response.body().getMessage().getBody().getTrackList()){
                        mTrackList.add(all.getTrack());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.e("onResponse123", response.toString());
            }

            @Override
            public void onFailure(Call<MessageWrapTrack> call, Throwable t) {
                Log.e("fail", t.toString());
            }
        });
    }

    private void receiveArtists(){
        App.getApi().getData(KEY, 1, COUNT_ARTIST, RUS).enqueue(new Callback<MessageWrap>() {
            @Override
            public void onResponse(Call<MessageWrap> call, Response<MessageWrap> response) {

                try {
                    for(ArtistList all : response.body().getMessage().getBody().getArtistList()){
                        mArtistList.add(all.getArtist());
                    }
                    updateUi();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.e("onResponse", response.toString());
            }

            @Override
            public void onFailure(Call<MessageWrap> call, Throwable t) {
                Log.e("fail", t.toString());
            }
        });
    }

    public void updateUi(){
        if (adapter == null) {
            adapter = new ListAdapter(mArtistList);
            mRecyclerView.setAdapter(adapter);
        }
        else {
            adapter.setArtistList(mArtistList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }
}


