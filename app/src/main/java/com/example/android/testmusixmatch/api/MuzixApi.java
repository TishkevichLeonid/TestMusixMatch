package com.example.android.testmusixmatch.api;

import com.example.android.testmusixmatch.models.ArtistModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public interface MuzixApi {

    @GET("/chart.artists.get")
    Call<List<ArtistModel>> getData(@Query("apikey") String apiKey,
                                    @Query("page") int pageNumber,
                                    @Query("page_size") int pageSize,
                                    @Query("country") String country,
                                    @Query("format") String format);

}