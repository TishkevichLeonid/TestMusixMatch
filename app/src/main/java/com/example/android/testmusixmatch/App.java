package com.example.android.testmusixmatch;

import android.app.Application;

import com.example.android.testmusixmatch.api.MuzixApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class App extends Application {

    private static MuzixApi sMuzixApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.musixmatch.com/ws/1.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sMuzixApi = mRetrofit.create(MuzixApi.class);
    }

    public static MuzixApi getApi(){
        return sMuzixApi;
    }
}
