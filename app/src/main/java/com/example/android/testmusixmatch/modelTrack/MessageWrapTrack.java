package com.example.android.testmusixmatch.modelTrack;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 09.09.17.
 */

public class MessageWrapTrack {

    @SerializedName("message")
    MessageTrack message;

    public MessageTrack getMessage() {
        return message;
    }

    public void setMessage(MessageTrack message) {
        this.message = message;
    }
}

