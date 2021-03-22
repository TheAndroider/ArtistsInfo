package com.generalmotors.artists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistResponseModel {
    @SerializedName("results")
    private List<ArtistInfoResults> artistInfoResultsList;

    @SerializedName("resultCount")
    private int resultCount = 0;

    public List<ArtistInfoResults> getArtistInfoResultsList() {
        return artistInfoResultsList;
    }

    public void setArtistInfoResultsList(List<ArtistInfoResults> artistInfoResultsList) {
        this.artistInfoResultsList = artistInfoResultsList;
    }

    public int getTotalCount() {
        return resultCount;
    }

    public void setTotalCount(int resultCount) {
        this.resultCount = resultCount;
    }
}
