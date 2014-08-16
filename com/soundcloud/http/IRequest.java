package com.soundcloud.http;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public interface IRequest {

    public void onRequestComplete(String response);
    public void onError(Exception e);

}
