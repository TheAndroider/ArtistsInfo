package com.generalmotors.artists;


import java.util.List;

public interface ArtistsInfoContract {
    interface ArtistsInfoPresenter{
        void getArtistsInfo(String artistsName);
    }
    interface ArtistsInfoView{
        void showProgressBar();
        void hideProgressBar();
        void showArtistInfoResults(List<ArtistInfoResults> artistInfoResults);
    }
}
