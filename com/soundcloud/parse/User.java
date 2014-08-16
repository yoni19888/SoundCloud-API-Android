package com.soundcloud.parse;

import com.soundcloud.represent.UserDetails;
import org.json.JSONObject;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class User {

    public static UserDetails parse(String response) throws Exception
    {
        JSONObject json = new JSONObject(response);

        return new UserDetails(
                json.getInt("id"),
                json.getString("permalink"),
                json.getString("username"),
                json.getString("permalink_url"),
                json.getString("avatar_url"),
                json.getString("country"),
                json.getString("first_name"),
                json.getString("last_name"),
                json.getString("description"),
                json.getString("city"),
                json.getBoolean("online"),
                json.getInt("track_count"),
                json.getInt("followers_count"),
                json.getInt("followings_count")
        );
    }

}
