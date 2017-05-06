package edu.cpp.l09_data_storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class MainActivity extends AppCompatActivity {

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
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();

        String[] projection = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.COLUMN_NAME_NAME,
                StudentContract.StudentEntry.COLUMN_NAME_MAJOR,
                StudentContract.StudentEntry.COLUMN_NAME_AGE,
        };

        String selection = StudentContract.StudentEntry.COLUMN_NAME_MAJOR + " = ?";
        String[] selectionArgs = { "cs" };

        Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

        List<Student> itemIds = new ArrayList<Student>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(StudentContract.StudentEntry._ID));
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME_NAME));
            String major = cursor.getString(
                    cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME_MAJOR));
            int age = cursor.getInt(
                    cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME_AGE));

            //itemIds.add(new Student(itemId, name, major, age));
        }
        cursor.close();

        ArrayAdapter<Student> studentsAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, itemIds);
        studentListView.setAdapter(studentsAdapter);
    }

    @OnClick(R.id.saveButton)
    void onClickSave() {
        String name = nameEditText.getText().toString();
        String major = majorEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());

        ContentValues values = new ContentValues();
        values.put(StudentContract.StudentEntry.COLUMN_NAME_NAME, name);
        values.put(StudentContract.StudentEntry.COLUMN_NAME_MAJOR, major);
        values.put(StudentContract.StudentEntry.COLUMN_NAME_AGE, age);

        SQLiteDatabase db = studentDBHelper.getWritableDatabase();
        db.insert(StudentContract.StudentEntry.TABLE_NAME, null, values);

        queryStudentsFromDB();
    }


}
