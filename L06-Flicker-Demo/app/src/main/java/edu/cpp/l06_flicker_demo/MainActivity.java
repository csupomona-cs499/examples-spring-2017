package edu.cpp.l06_flicker_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.cpp.l06_flicker_demo.data.GetRecentPhotosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gridview)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        FlickrService service = retrofit.create(FlickrService.class);

        Call<GetRecentPhotosResponse> call = service.getRecentPhotos(
                "flickr.photos.getRecent",
                "e3eaa0bebc998ee957775d942766c6e8",
                "url_s",
                "json", 1);

        call.enqueue(new Callback<GetRecentPhotosResponse>() {
            @Override
            public void onResponse(Call<GetRecentPhotosResponse> call, Response<GetRecentPhotosResponse> response) {
//                Log.i("TEST", response.body().getStat());
                ImageAdapter imageAdapter = new ImageAdapter(MainActivity.this, response.body());
                gridView.setAdapter(imageAdapter);
            }

            @Override
            public void onFailure(Call<GetRecentPhotosResponse> call, Throwable t) {
                Log.i("TEST", "Failed to get the photos");
            }
        });
    }
}
