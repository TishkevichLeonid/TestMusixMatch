package com.example.android.testmusixmatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.testmusixmatch.models.Artist;
import com.example.android.testmusixmatch.models.ArtistList;
import com.example.android.testmusixmatch.models.MessageWrap;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test_log";
    public static final String KEY = "e9693a724b2cff4dfde5fc39f9bc85a6";
    public static final String RUS = "ru";
    public static final String ITALY = "it";
    public static final int COUNT_ARTIST = 100;

    private RecyclerView mRecyclerView;
    private List<Artist> mArtistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArtistList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        Log.d(TAG, "вызов1");

        ListAdapter adapter = new ListAdapter(mArtistList);
        mRecyclerView.setAdapter(adapter);
        Log.d(TAG, "вызов2");

        App.getApi().getData(KEY, 1, COUNT_ARTIST, RUS).enqueue(new Callback<MessageWrap>() {
            @Override
            public void onResponse(Call<MessageWrap> call, Response<MessageWrap> response) {

                try {
                    for(ArtistList all : response.body().getMessage().getBody().getArtistList()){
                        mArtistList.add(all.getArtist());
                    }
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.e("onResponse", "_" + response.toString());
            }

            @Override
            public void onFailure(Call<MessageWrap> call, Throwable t) {
                Log.e("fail", t.toString());

            }
        });
    }
}


