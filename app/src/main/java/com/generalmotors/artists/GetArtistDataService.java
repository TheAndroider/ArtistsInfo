package com.generalmotors.artists;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface GetArtistDataService {

    /**
     * Gets list.
     *
     * @param artistName the artistName
     * @return the list
     */
    @Streaming
    @GET("search?")
    Observable<ArtistResponseModel> getArtistDataList(@Query("term") String artistName,@Query("limit") String pageSize,@Query("offset") String offset);
}
