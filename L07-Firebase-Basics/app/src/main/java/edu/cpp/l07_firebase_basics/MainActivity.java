package edu.cpp.l07_firebase_basics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.courseIdEditText)
    EditText idEditText;
    @BindView(R.id.courseNameEditText)
    EditText nameEditText;
    @BindView(R.id.courseHoursEditText)
    EditText hoursEditText;
    @BindView(R.id.courseRatingBar)
    RatingBar ratingBar;
    @BindView(R.id.courseListView)
    ListView courseListView;

    private List<Course> courseList;
    private DatabaseReference myRef;

    private FirebaseAuth mAuth;
    private FirebaseStorage storage;

    private static final int REQUEST_IMAGE_CAPTURE = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("courses");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                courseList = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Course c = ds.getValue(Course.class);
                    courseList.add(c);
                }
                CourseListViewAdapter courseListViewAdapter = new CourseListViewAdapter(
                        MainActivity.this, R.layout.listview_course_item, courseList);
                courseListView.setAdapter(courseListViewAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.submitButton)
    void submitOnClick() {
//        Course course = new Course();
//        course.setId(idEditText.getText().toString());
//        course.setName(nameEditText.getText().toString());
//        course.setHours(Integer.parseInt(hoursEditText.getText().toString()));
//        course.setRatings(ratingBar.getRating());

        //myRef.child(course.getId()).setValue(course);

        dispatchTakePictureIntent();
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "edu.cpp.l07_firebase_basics",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Log.i("TEST", "Photo taken at " + mCurrentPhotoPath);
        }
    }

}
