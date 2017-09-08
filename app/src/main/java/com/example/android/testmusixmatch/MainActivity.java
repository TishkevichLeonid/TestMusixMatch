package com.example.android.testmusixmatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.testmusixmatch.models.ArtistModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test_log";

    private RecyclerView mRecyclerView;
    private List<ArtistModel> mArtistList;

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

        App.getApi().getData("e9693a724b2cff4dfde5fc39f9bc85a6", 1, 3, "it", "json").enqueue(new Callback<List<ArtistModel>>() {
            @Override
            public void onResponse(Call<List<ArtistModel>> call, Response<List<ArtistModel>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "вызов3");
                    Toast.makeText(MainActivity.this, "sucssesful query", Toast.LENGTH_SHORT);
                    Log.d(TAG, "вызов4");
                    mArtistList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                }
                else Toast.makeText(MainActivity.this, "server is unavalible", Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<List<ArtistModel>> call, Throwable t) {
                Log.d(TAG, "вызов5");
                Toast.makeText(MainActivity.this, "error with query",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
