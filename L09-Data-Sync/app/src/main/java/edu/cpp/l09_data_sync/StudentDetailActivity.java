package edu.cpp.l09_data_sync;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.paperdb.Paper;

/**
 * Created by yusun on 5/3/17.
 */

public class StudentDetailActivity extends Activity {

    @BindView(R.id.idTextView)
    TextView idTextView;
    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.majorTextView)
    TextView majorTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_details);

        ButterKnife.bind(this);

        int id = getIntent().getIntExtra("id", 0);

        Student student = getStudent(id);

        idTextView.setText(student.getId() + " ");
        nameTextView.setText(student.getName());
        majorTextView.setText(student.getMajor());
    }

    private Student getStudent(int id) {
        List<Student> students = Paper.book().read("stu-list-cache");
        return students.get(id);
    }
}
