package com.soundcloud;

import com.soundcloud.exception.InvalidClientDetails;
import com.soundcloud.http.HttpRequest;
import com.soundcloud.http.IRequest;
import com.soundcloud.parse.Track;
import com.soundcloud.parse.User;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class API{

    //API Details
    private static String clientId;
    private static String clientSecret;

    //Internal data
    public static final String API = "http://api.sndcdn.com/";

    public API(String clientId, String clientSecret)
    {
        this.clientId     = clientId;
        this.clientSecret = clientSecret;
    }

    public void getTrack(final ISndcdn listener, final String trackUrl) throws Exception
    {
        IRequest iRequest = new IRequest() {
            @Override
            public void onRequestComplete(String response) {
                try{
                    listener.onSuccess(Track.parse(response));
                }
                catch (Exception e){
                    e.printStackTrace();
                    listener.onFail(e);
                }
            }

            @Override
            public void onError(Exception e) {
                listener.onFail(e);
            }
        };

        sendRequest(
                listener,
                iRequest,
                API + "resolve?url=" + trackUrl + "&format=json&client_id=" + clientId
        );
    }

    public void getUser(final ISndcdn listener, final int userId) throws Exception
    {
        IRequest iRequest = new IRequest() {
            @Override
            public void onRequestComplete(String response) {
                try{
                    listener.onSuccess(User.parse(response));
                }
                catch (Exception e){
                    e.printStackTrace();
                    listener.onFail(e);
                }
            }

            @Override
            public void onError(Exception e) {
                listener.onFail(e);
            }
        };

        sendRequest(
                listener,
                iRequest,
                API + "users/" + userId + "?format=json&client_id=" + clientId
        );
    }

    private void sendRequest(final ISndcdn listener, IRequest iRequest, String url)
    {
        if(clientId == null || clientSecret == null)
        {
            //Empty clientId or clientSecret - Throw exception
            listener.onFail(new InvalidClientDetails());

            return;
        }

        HttpRequest request = new HttpRequest(iRequest);
        request.execute(url);
    }

    public static String getAi()
    {
        return API;
    }

    public static String getClientId()
    {
        return clientId;
    }

    public static String getClientSecret()
    {
        return clientSecret;
    }
}
