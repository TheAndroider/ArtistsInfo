package com.generalmotors.artists;

import com.google.gson.annotations.SerializedName;

public class ArtistInfoResults {
    @SerializedName("artistName")
    private String artistName;

    @SerializedName("trackName")
    private String trackName;

    @SerializedName("collectionPrice")
    private double trackPrice =0.00;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("primaryGenreName")
    private String primaryGenreName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = artistName;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }
}
