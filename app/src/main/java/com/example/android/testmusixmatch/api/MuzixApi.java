package com.example.android.testmusixmatch.api;

import com.example.android.testmusixmatch.models.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public interface MuzixApi {

    @GET("ws/1.1/chart.artists.get")
    Call<List<Artist>> getData(@Query("page") int pageNumber, @Query("page_size")
            int pageSize, @Query("country") String country);

}