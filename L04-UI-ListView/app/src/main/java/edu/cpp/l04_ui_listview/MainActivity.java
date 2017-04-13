package edu.cpp.l04_ui_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<PhoneType> phoneTypeList;
    private PhoneTypeArrayAdapter phoneTypeArrayAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        initPhoneTypes();

        listView = (ListView) findViewById(R.id.phoneTypeListView);

        phoneTypeArrayAdapter = new PhoneTypeArrayAdapter(
                this,R.layout.listview_item_view, phoneTypeList);

        listView.setAdapter(phoneTypeArrayAdapter);
    }

    private void initPhoneTypes() {
        phoneTypeList = new ArrayList<PhoneType>() {{
            add(new PhoneType("Android", true));
            add(new PhoneType("iPhone", false));
            add(new PhoneType("Windows Phone", true));
            add(new PhoneType("Linux", true));
            add(new PhoneType("OS/2", true));
            add(new PhoneType("WebOS", true));
            add(new PhoneType("Android", true));
            add(new PhoneType("iPhone", false));
            add(new PhoneType("Windows Phone", true));
            add(new PhoneType("Linux", true));
            add(new PhoneType("OS/2", true));
            add(new PhoneType("WebOS", true));
            add(new PhoneType("Android", true));
            add(new PhoneType("iPhone", false));
            add(new PhoneType("Windows Phone", true));
            add(new PhoneType("Linux", true));
            add(new PhoneType("OS/2", true));
            add(new PhoneType("WebOS", true));
        }};
    }
}
