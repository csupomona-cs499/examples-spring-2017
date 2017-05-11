package edu.cpp.l12_fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yusun on 5/8/17.
 */

public class DetailedActivity extends AppCompatActivity {

    private boolean toggle = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button button = (Button) findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, new Demo1Fragment());
                    fragmentTransaction.commit();
                    toggle = !toggle;
                } else {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, new Demo2Fragment());
                    fragmentTransaction.commit();
                    toggle = !toggle;
                }
//                Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}
