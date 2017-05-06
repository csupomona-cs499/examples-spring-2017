package edu.cpp.l09_data_storage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.paperdb.Paper;

public class MainActivityWithPaperLib extends AppCompatActivity {

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
        List<Student> studentList = Paper.book().read("students");
        if (studentList != null) {
            ArrayAdapter<Student> studentsAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, studentList);
            studentListView.setAdapter(studentsAdapter);
        }
    }

    @OnClick(R.id.saveButton)
    void onClickSave() {
        String name = nameEditText.getText().toString();
        String major = majorEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());

        Student student = new Student(name, major, age);

        List<Student> studentList = Paper.book().read("students");
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
        studentList.add(student);
        Paper.book().write("students", studentList);

        queryStudentsFromDB();
    }


}
