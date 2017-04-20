package edu.cpp.l05_http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yusun on 4/19/17.
 */

public interface BusService {

    @GET("/Route/3164/Vehicles")
    Call<List<RouteInfo>> getRouteVehicles();

}
