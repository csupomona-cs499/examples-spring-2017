package edu.cpp.l07_firebase_basics;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yusun on 4/24/17.
 */

public class CourseListViewAdapter extends ArrayAdapter<Course> {

    private Context context;
    private List<Course> courses;
    private int resource;

    public CourseListViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Course> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.courses = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resource, parent, false);

        TextView idTextView = (TextView) view.findViewById(R.id.courseIdTextView);
        TextView nameTextView = (TextView) view.findViewById(R.id.courseNameTextView);
        TextView hoursTextView = (TextView) view.findViewById(R.id.courseHoursTextView);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.courseItemRatingBar);

        idTextView.setText(courses.get(position).getId());
        nameTextView.setText(courses.get(position).getName());
        hoursTextView.setText(courses.get(position).getHours() + " ");
        ratingBar.setRating((float) courses.get(position).getRatings());

        return view;
    }
}
