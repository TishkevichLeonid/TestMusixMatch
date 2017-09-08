package com.example.android.testmusixmatch.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 09.09.17.
 */

public class MessageWrap {

    @SerializedName("message")
    Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
