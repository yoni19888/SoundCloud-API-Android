package com.soundcloud;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public interface ISndcdn {

    public void onSuccess(Object result);
    public void onFail(Exception e);
}
