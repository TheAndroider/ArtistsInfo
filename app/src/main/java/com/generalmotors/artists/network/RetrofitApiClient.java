package com.generalmotors.artists;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    private static Retrofit retrofit;
    private GetArtistDataService myAppService;

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static Retrofit createRetrofitService(final String endPoint) {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(endPoint)
                    .client(HttpClient.getInstance())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
