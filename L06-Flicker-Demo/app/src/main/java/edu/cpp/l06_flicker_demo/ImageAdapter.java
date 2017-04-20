package edu.cpp.l06_flicker_demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import edu.cpp.l06_flicker_demo.data.GetRecentPhotosResponse;
import edu.cpp.l06_flicker_demo.data.Photo;

/**
 * Created by yusun on 4/19/17.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private GetRecentPhotosResponse response;

    public ImageAdapter(Context c, GetRecentPhotosResponse response) {
        mContext = c;
        this.response = response;
    }

    public int getCount() {
        return response.getPhotos().getPhoto().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final Photo photo = response.getPhotos().getPhoto().get(position);
        String url = photo.getUrl_s();
        ImageView imageView = new ImageView(mContext);
        Picasso.with(mContext).load(url).resize(200, 200).centerCrop().into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, photo.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }

}
