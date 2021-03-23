package com.generalmotors.artists;

import android.content.Context;

public interface MainPresenterContract {
 interface Presenter {
     void showArtistDataResults(Context context, String artistName);

 }
}
