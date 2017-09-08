package com.example.android.testmusixmatch.api;

import com.example.android.testmusixmatch.models.MessageWrap;

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

     /*  MessageWrap - то что нам должен вернуть сервер (структуру сущностей ранее описывал)
        getData - название по которому будешь обращатся к методу для запроса на сервер
    далее идет набор параметров, которые нужно передать в метод

    /*@GET("chart.artists.get")
    Call<List<Artist>> getData(@Query("apikey") String apiKey,
                               @Query("page") int pageNumber,
                               @Query("page_size") int pageSize,
                               @Query("country") String country
                                    );*/

}