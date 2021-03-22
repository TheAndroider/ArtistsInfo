package com.generalmotors.artists;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivityPresenter implements MainPresenterContract.Presenter {
    MainPresenterContract.Presenter presenter;
    private String TAG ="MainPresenter";

    public MainActivityPresenter(MainPresenterContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void showArtistDataResults(Context context, String artistName) {
        Intent intent = new Intent(context,ArtistInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("artistName",artistName);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
