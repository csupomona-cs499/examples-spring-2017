package edu.cpp.l06_flicker_demo;

import edu.cpp.l06_flicker_demo.data.GetRecentPhotosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yusun on 4/19/17.
 */

public interface FlickrService {

    @GET("/services/rest/")
    Call<GetRecentPhotosResponse> getRecentPhotos(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("extras") String extras,
            @Query("format") String format,
            @Query("nojsoncallback") int nojsoncallback
    );
}
