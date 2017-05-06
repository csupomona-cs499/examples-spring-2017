package edu.cpp.l09_data_storage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityWithActiveAndroidLib extends AppCompatActivity {

    @BindView(R.id.nameEditText)
    EditText nameEditText;
    @BindView(R.id.majorEditText)
    EditText majorEditText;
    @BindView(R.id.ageEditText)
    EditText ageEditText;
    @BindView(R.id.studentListView)
    ListView studentListView;

    private StudentDBHelper studentDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitity_student);

        ButterKnife.bind(this);
        studentDBHelper = new StudentDBHelper(this);

        queryStudentsFromDB();
    }

    private void queryStudentsFromDB() {
//        List<Student> students = new Select().from(Student.class).execute();
//        ArrayAdapter<Student> studentsAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);
//        studentListView.setAdapter(studentsAdapter);
    }

    @OnClick(R.id.saveButton)
    void onClickSave() {
        String name = nameEditText.getText().toString();
        String major = majorEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());

        Student student = new Student(name, major, age);
        //student.save();

        queryStudentsFromDB();
    }


}
