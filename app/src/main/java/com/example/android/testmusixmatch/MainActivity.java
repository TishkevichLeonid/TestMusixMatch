package com.example.android.testmusixmatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.testmusixmatch.models.Artist;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test_log";

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

        ListAdapter adapter = new ListAdapter(mArtistList);
        mRecyclerView.setAdapter(adapter);
        Log.d(TAG, "вызов1");

        App.getApi().getData("e9693a724b2cff4dfde5fc39f9bc85a6", 1, 3, "it").enqueue(new Callback<List<Artist>>() {
            @Override
            public void onResponse(Call<List<Artist>> call, Response<List<Artist>> response) {
                Log.d(TAG, "вызов2");
                mArtistList.addAll(response.body());
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Artist>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
