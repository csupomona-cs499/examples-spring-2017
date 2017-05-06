package edu.cpp.l09_data_storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityWithSharePrefs extends AppCompatActivity {

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
        SharedPreferences sharedPreferences = getSharedPreferences("studentlist", Context.MODE_PRIVATE);
        List<Student> studentList = null;
        String stuListStr = sharedPreferences.getString("stulist", null);
        if (stuListStr == null) {
            studentList = new ArrayList<>();
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                studentList = objectMapper.readValue(stuListStr, new TypeReference<List<Student>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<Student> studentsAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, studentList);
        studentListView.setAdapter(studentsAdapter);
    }

    @OnClick(R.id.saveButton)
    void onClickSave() {
        String name = nameEditText.getText().toString();
        String major = majorEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());

        Student student = new Student(name, major, age);


        SharedPreferences sharedPreferences = getSharedPreferences("studentlist", Context.MODE_PRIVATE);
        List<Student> studentList = null;
        String stuListStr = sharedPreferences.getString("stulist", null);
        if (stuListStr == null) {
            studentList = new ArrayList<>();
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                studentList = objectMapper.readValue(stuListStr, new TypeReference<List<Student>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        studentList.add(student);

        ObjectMapper objectMapper = new ObjectMapper();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        try {
            editor.putString("stulist", objectMapper.writeValueAsString(studentList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        editor.commit();

        queryStudentsFromDB();
    }


}
