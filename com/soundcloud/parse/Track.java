package com.soundcloud.parse;

import com.soundcloud.API;
import com.soundcloud.represent.TrackDetails;

import org.json.JSONObject;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class Track{

    public static TrackDetails parse(String response) throws Exception
    {
        JSONObject json = new JSONObject(response);

        return new TrackDetails(
                json.getInt("id"),
                json.getString("created_at"),
                json.getInt("user_id"),
                json.getInt("duration"),
                json.getString("sharing"),
                json.getString("title"),
                json.getString("description"),
                json.getString("artwork_url"),
                json.getString("permalink_url"),
                API.getAi() + "tracks/" + json.getInt("id") + "/stream?consumer_key=" + API.getClientId()
        );
    }



}
