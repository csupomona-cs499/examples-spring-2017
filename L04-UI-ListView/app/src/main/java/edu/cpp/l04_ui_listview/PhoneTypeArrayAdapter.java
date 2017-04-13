package edu.cpp.l04_ui_listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yusun on 4/12/17.
 */

public class PhoneTypeArrayAdapter extends ArrayAdapter<PhoneType> {

    private Context context;
    private int layoutResource;
    private List<PhoneType> phoneTypeList;

    public PhoneTypeArrayAdapter(@NonNull Context context,
                                 @LayoutRes int resource,
                                 @NonNull List<PhoneType> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.phoneTypeList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResource, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.statusIcon);
        if (phoneTypeList.get(position).isCompatible()) {
            imageView.setImageResource(android.R.drawable.ic_dialog_email);
        } else {
            imageView.setImageResource(android.R.drawable.ic_dialog_map);
        }
        TextView textView = (TextView) view.findViewById(R.id.phoneTypeTextView);
        textView.setText(phoneTypeList.get(position).getName());

        return view;
    }
}
