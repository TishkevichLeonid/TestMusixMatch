package com.example.android.testmusixmatch.api;

import com.example.android.testmusixmatch.modelArtist.MessageWrap;
import com.example.android.testmusixmatch.modelTrack.MessageWrapTrack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public interface MuzixApi {

    @GET("chart.artists.get")
    Call<MessageWrap> getData(@Query("apikey") String apiKey,
                              @Query("page") int pageNumber,
                              @Query("page_size") int pageSize,
                              @Query("country") String country
    );

    @GET("chart.tracks.get")
    Call<MessageWrapTrack> getDataTrack(@Query("apikey") String apiKey,
                                        @Query("page") int pageNumber,
                                        @Query("page_size") int pageSize,
                                        @Query("country") String country

    );

}