package com.example.android.testmusixmatch.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 08.09.17.
 */

public class Message {

    @SerializedName("body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
