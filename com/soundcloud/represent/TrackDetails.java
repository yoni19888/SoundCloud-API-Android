package com.soundcloud.represent;

/**
 * Simple Sound Cloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class TrackDetails {

    private int id;
    private String createdAt;
    private int userId;
    private int duration;
    private String sharing;
    private String title;
    private String description;
    private String artWork;

    private String url;
    private String streamUrl;


    public TrackDetails(int id, String createdAt, int userId, int duration, String sharing, String title, String description, String artWork, String url, String streamUrl)
    {
        this.id          = id;
        this.createdAt   = createdAt;
        this.userId      = userId;
        this.duration    = duration;
        this.sharing     = sharing;
        this.title       = title;
        this.description = description;
        this.artWork     = artWork;
        this.url         = url;
        this.streamUrl   = streamUrl;
    }

    public int getId()
    {
        return this.id;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public String getSharing()
    {
        return sharing;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getArtWork()
    {
        return artWork;
    }

    public String getUrl()
    {
        return url;
    }

    public String getStreamUrl()
    {
        return streamUrl;
    }
}
