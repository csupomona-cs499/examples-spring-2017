package edu.cpp.l08_quiz_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.questionTextView)
    TextView questionTextView;

    @BindView(R.id.answerEditText)
    EditText answerEditText;
    @BindView(R.id.leaderBoardListView)
    ListView leaderListView;

    private FirebaseDatabase database;
    private String username;
    private Long startTime;
    private Question question;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ButterKnife.bind(this);

        username = this.getIntent().getStringExtra("username");
        nameTextView.setText(username);

        database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("question");
        reference = database.getReference("leaderboard");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                startTime = System.currentTimeMillis();
                question = dataSnapshot.getValue(Question.class);
                questionTextView.setText(question.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Record> recordList = new ArrayList<Record>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Record r = new Record();
                    r.setName(ds.getKey());
                    r.setTimespent(ds.getValue(Long.class));
                    recordList.add(r);
                }

                Collections.sort(recordList, new Comparator<Record>() {
                    @Override
                    public int compare(Record t1, Record t2) {
                        return t1.getTimespent().compareTo(t2.getTimespent());
                    }
                });

                ArrayAdapter<Record> adapter = new ArrayAdapter<Record>(MainActivity.this, android.R.layout.simple_list_item_1, recordList);
                leaderListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.submitButton)
    void submit() {
        String answer = answerEditText.getText().toString();
        try {
            int result = Integer.parseInt(answer);
            if (result == question.getCorrectAnswer()) {
                long timespent = System.currentTimeMillis() - startTime;
                DatabaseReference dref = database.getReference("leaderboard/" + username);
                dref.setValue(timespent);
            }
        } catch (Exception e) {

        }
    }
}
