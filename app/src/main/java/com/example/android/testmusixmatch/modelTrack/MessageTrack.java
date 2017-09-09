package com.example.android.testmusixmatch.modelTrack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 09.09.17.
 */

public class MessageTrack {

    @SerializedName("body")
    @Expose
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
