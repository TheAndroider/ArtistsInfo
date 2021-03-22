package com.generalmotors.artists;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ArtistInfoPresenterImp implements ArtistsInfoContract.ArtistsInfoPresenter{
    private static final String URL = "https://itunes.apple.com";
   ArtistsInfoContract.ArtistsInfoView artistsInfoView;
   private View view;
   List<ArtistInfoResults> artistInfoList = new ArrayList<>();

   public ArtistInfoPresenterImp(ArtistsInfoContract.ArtistsInfoView artistsInfoView){
       this.artistsInfoView = artistsInfoView;
   }

    @Override
    public void getArtistsInfo(String artistsName, int pageSize, int size) {
        artistsInfoView.showProgressBar();
        Observable<ArtistResponseModel> observable = RetrofitApiClient.createRetrofitService(URL).create(GetArtistDataService.class)
                .getArtistDataList(artistsName,String.valueOf(pageSize),String.valueOf(size))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new DisposableObserver<ArtistResponseModel>() {

                    @Override
                    protected void onStart() {
                        super.onStart();
                        artistsInfoView.showProgressBar();

                    }
                    @Override
                    public void onNext(@NonNull ArtistResponseModel artistResponseModel) {
                        if(artistResponseModel!=null){
//                            artistResponseModel.setArtistInfoResultsList(artistResponseModel.getArtistInfoResultsList());
                            Log.d("ArtistResults",artistResponseModel.getArtistInfoResultsList().toString());
                            artistsInfoView.showArtistInfoResults(artistResponseModel.getArtistInfoResultsList());

                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Error",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        artistsInfoView.hideProgressBar();
                    }
                });
    }

    @Override
    public void attach(View view) {
        this.view = view;
    }

    @Override
    public void detach() {
          view = null;
    }

    @Override
    public void itemCount(int count) {

    }

    @Override
    public void onItemClicked(int postion) {

    }

    @Override
    public void onBindItemView(ArtistsInfoContract.ItemView itemView, int position) {
//itemView.bindItem();
    }
}
