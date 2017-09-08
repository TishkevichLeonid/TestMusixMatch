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

        final ListAdapter adapter = new ListAdapter(mArtistList);
        mRecyclerView.setAdapter(adapter);
        Log.d(TAG, "вызов2");

        App.getApi().getData(KEY, 1,3,"it").enqueue(new Callback<MessageWrap>() {
            @Override
            public void onResponse(Call<MessageWrap> call, Response<MessageWrap> response) {

                try {
                    for(ArtistList al : response.body().getMessage().getBody().getArtistList()){
                        mArtistList.add(al.getArtist());
                    }
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.e("onResponse", "_" + response.toString());
                Log.e("tttt", "вывод - у тебя очень плохая структура ответа и придется делать обертки, как я сделал для класс message");

            }

            @Override
            public void onFailure(Call<MessageWrap> call, Throwable t) {
                Log.e("fail", t.toString());

            }
        });  //с от

        /*App.getApi().getData(KEY, 1, 3, "it").enqueue(new Callback<List<Artist>>() {
            @Override
            public void onResponse(Call<List<Artist>> call, Response<List<Artist>> response) {
                if (response.isSuccessful()) {
                    mArtistList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "server is unavailable", Toast.LENGTH_SHORT).show();
                }
            }
            // понял, сейчас попробуем

            @Override
            public void onFailure(Call<List<Artist>> call, Throwable t) {
                Log.d(TAG, t.toString());
                Toast.makeText(MainActivity.this, "error",
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}


