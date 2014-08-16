package com.soundcloud;

import android.util.Log;

import com.soundcloud.represent.TrackDetails;
import com.soundcloud.represent.UserDetails;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class Example {

    private API sndcdn;

    private TrackDetails trackDetails;
    private UserDetails userDetails;

    //Track details
    private String trackTitle;
    private String trackStream;
    private String trackDescription;
    private int trackUploaderId;

    //User details
    private String userName;
    private String userAvatar;

    public Example()
    {
        sndcdn = new API("<User client>", "<User secret>");

        getTrackDetails("<Track url>");
    }

    private void getTrackDetails(String trackUrl)
    {
        try{
            sndcdn.getTrack(
                    new ISndcdn() {
                        @Override
                        public void onSuccess(Object result) {
                            trackDetails = (TrackDetails) result;

                            trackTitle  = trackDetails.getTitle();
                            trackStream = trackDetails.getStreamUrl();
                            trackDescription = trackDetails.getDescription();
                            trackUploaderId  = trackDetails.getUserId();

                            getUserDetails(trackDetails.getUserId());
                        }

                        @Override
                        public void onFail(Exception e) {
                            //Something here...
                        }
                    },

                    trackUrl
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getUserDetails(int userId)
    {
        try{
            sndcdn.getUser(
                    new ISndcdn() {
                        @Override
                        public void onSuccess(Object result) {
                            userDetails = (UserDetails) result;

                            userName   = userDetails.getUsername();
                            userAvatar = userDetails.getAvatar();
                        }

                        @Override
                        public void onFail(Exception e) {
                            //Something here...
                        }
                    },

                    userId
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
