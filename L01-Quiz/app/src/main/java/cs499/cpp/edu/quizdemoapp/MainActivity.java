package cs499.cpp.edu.quizdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cs499.cpp.edu.quizdemoapp.model.QuizQuestion;

public class MainActivity extends AppCompatActivity {

    private List<QuizQuestion> questionList;
    private int currentSelectedQuestion;

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Test", "onCreate()");

        initQuestions();
        updateQuestion();

        trueButton = (Button) findViewById(R.id.trueButton);
        trueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(true);
            }
        });

        falseButton = (Button) findViewById(R.id.falseButton);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(false);
            }
        });

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSelectedQuestion++;
                if (currentSelectedQuestion == questionList.size()) {
                    currentSelectedQuestion = 0;
                }
                updateQuestion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TEST", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TEST", "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TEST", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TEST", "onDestory()");
    }

    /**
     * Check wehter the answer is correct.
     *
     * @param userAnswer This is the input user gives
     */
    private void checkCorrectAnswer(boolean userAnswer) {
        if (questionList.get(currentSelectedQuestion).getCorrectAnswer() == userAnswer) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion() {
        titleTextView = (TextView) findViewById(R.id.questionTitleTextView);
        titleTextView.setText(questionList.get(currentSelectedQuestion).getTitle());
    }

    private void initQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new QuizQuestion("NYC is the largest city in the US.", true));
        questionList.add(new QuizQuestion("CA is the largest state in the US.", false));
        questionList.add(new QuizQuestion("CS499 is the best.", true));
        questionList.add(new QuizQuestion("Wed has no classes.", false));

        currentSelectedQuestion = 0;
    }
}

