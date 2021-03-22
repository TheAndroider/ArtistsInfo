package com.generalmotors.artists;

import android.view.View;

import java.util.List;

public interface ArtistsInfoContract {
    interface ArtistsInfoPresenter{
        void getArtistsInfo(String artistsName, int pageSize, int size);
        void attach(View view);
        void detach();
        void itemCount(int count);
        void onItemClicked(int postion);
        void onBindItemView(ItemView itemView, int position);
    }

    interface ArtistsInfoView{
        void showProgressBar();
        void hideProgressBar();
        void showArtistInfoResults(List<ArtistInfoResults> artistInfoResults);
    }
    interface ItemView{
        void bindItem(ArtistInfo artistInfo);
    }
}
