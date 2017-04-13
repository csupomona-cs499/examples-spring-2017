package edu.cpp.l04_ui_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FriendRecommendationActivity extends AppCompatActivity {

    private List<FriendRecommendation> friendRecommendationList;
    private ListView listView;
    private FriendRecommendationArrayAdapter friendRecommendationArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        initFriendRecommendations();

        Button button = (Button) findViewById(R.id.createRecommendationButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FriendRecommendation friendRecommendation =
                        new FriendRecommendation("New Friend",
                                new Random().nextInt(30),
                                R.drawable.friend_5);
                friendRecommendationArrayAdapter.add(friendRecommendation);
                friendRecommendationArrayAdapter.notifyDataSetChanged();
            }
        });

        listView = (ListView) findViewById(R.id.phoneTypeListView);
        friendRecommendationArrayAdapter = new FriendRecommendationArrayAdapter(
                this, R.layout.listview_friend_item, friendRecommendationList);

        listView.setAdapter(friendRecommendationArrayAdapter);
    }

    private void initFriendRecommendations() {
        friendRecommendationList = new ArrayList<FriendRecommendation>() {{
            add(new FriendRecommendation("Allison", 24, R.drawable.friend_1));
            add(new FriendRecommendation("Jenny", 2, R.drawable.friend_2));
            add(new FriendRecommendation("Meghan", 14, R.drawable.friend_3));
            add(new FriendRecommendation("David", 5, R.drawable.friend_4));
            add(new FriendRecommendation("Eric", 19, R.drawable.friend_5));
            add(new FriendRecommendation("Tom", 20, R.drawable.friend_6));
            add(new FriendRecommendation("Amy", 24, R.drawable.friend_1));
            add(new FriendRecommendation("Ben", 2, R.drawable.friend_2));
            add(new FriendRecommendation("Carol", 14, R.drawable.friend_3));
            add(new FriendRecommendation("Frank", 5, R.drawable.friend_4));
            add(new FriendRecommendation("Ryan", 19, R.drawable.friend_5));
            add(new FriendRecommendation("Anthony", 20, R.drawable.friend_6));
        }};
    }
}
