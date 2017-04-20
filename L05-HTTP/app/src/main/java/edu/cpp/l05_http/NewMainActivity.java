package edu.cpp.l05_http;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by yusun on 4/19/17.
 */

public class NewMainActivity extends Activity {

    @BindView(R.id.getBusInfoButton)
    Button getBusInfoButton;
    @BindView(R.id.busListView)
    ListView busListView;

    private BusService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://broncoshuttle.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(BusService.class);
    }

    @OnClick(R.id.getBusInfoButton)
    void onGetBusInfoButtonClick() {
        Call<List<RouteInfo>> routeInfoCall = service.getRouteVehicles();
        routeInfoCall.enqueue(new Callback<List<RouteInfo>>() {
            @Override
            public void onResponse(Call<List<RouteInfo>> call, Response<List<RouteInfo>> response) {
                List<RouteInfo> routes = response.body();
                ArrayAdapter<RouteInfo> arrayAdapter = new ArrayAdapter<RouteInfo>(
                        NewMainActivity.this,android.R.layout.simple_list_item_1,routes);
                busListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<RouteInfo>> call, Throwable t) {
                Log.e("TEST", "Failed to get the bus info");
            }
        });
    }
}
