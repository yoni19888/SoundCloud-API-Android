package com.soundcloud.represent;

/**
 * Simple Sound Cloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class UserDetails {

    private int id;
    private String permalink;
    private String username;
    private String permalinkUrl;
    private String avatar;
    private String country;
    private String firstName;
    private String lastName;
    private String description;
    private String city;
    private boolean online;
    private int trackCount;
    private int followers;
    private int followings;

    public UserDetails(int id, String permalink, String username, String permalinkUrl, String avatar, String country, String firstName, String lastName, String description, String city, boolean online, int trackCount, int followers, int followings)
    {
        this.id           = id;
        this.permalink    = permalink;
        this.username     = username;
        this.permalinkUrl = permalinkUrl;
        this.avatar       = avatar;
        this.country      = country;
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.description  = description;
        this.city         = city;
        this.online       = online;
        this.trackCount   = trackCount;
        this.followers    = followers;
        this.followings   = followings;
    }


    public int getId()
    {
        return id;
    }

    public String getPermalink()
    {
        return permalink;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPermalinkUrl()
    {
        return permalinkUrl;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getCountry()
    {
        return country;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getDescription()
    {
        return description;
    }

    public String getCity()
    {
        return city;
    }

    public boolean getOnline()
    {
        return online;
    }

    public int getTrackCount()
    {
        return trackCount;
    }

    public int getFollowers()
    {
        return followers;
    }

    public int getFollowings()
    {
        return followings;
    }


}
