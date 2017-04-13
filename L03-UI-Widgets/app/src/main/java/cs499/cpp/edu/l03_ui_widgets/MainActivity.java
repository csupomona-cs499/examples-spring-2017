package cs499.cpp.edu.l03_ui_widgets;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private Button visControlButton;

    private Button submitButton;
    private EditText inputEditText;

    private RatingBar reviewRatingBar;
    private ImageButton reviewButton;

    private SeekBar gradeSeekBar;
    private TextView progressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);


        titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText("CS499 Spring 2017");


        visControlButton = (Button) findViewById(R.id.visibilityControllButton);
        visControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titleTextView.getVisibility() == View.INVISIBLE) {
                    titleTextView.setVisibility(View.VISIBLE);
                } else {
                    titleTextView.setVisibility(View.INVISIBLE);
                }
            }
        });

        inputEditText = (EditText) findViewById(R.id.inputEditText);
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Ready to Submit?")
                        .setMessage("Are you sure you want to submit this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String message = inputEditText.getText().toString();
                                Toast.makeText(MainActivity.this, "Your entry has been submitted.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        gradeSeekBar = (SeekBar) findViewById(R.id.gradeSeekBar);
        progressTextView = (TextView) findViewById(R.id.currentProgressTextView);

        gradeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressTextView.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        reviewRatingBar = (RatingBar) findViewById(R.id.reviewRatingBar);
        reviewButton = (ImageButton) findViewById(R.id.reviewButton);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "You gave a " + reviewRatingBar.getRating() + " stars to CPP.", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "You gave a " + gradeSeekBar.getProgress() + " stars to CPP.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });


    }
}
