package edu.cpp.l09_data_sync;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView stuListView;

    private List<Student> students;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        ButterKnife.bind(this);

        // load cached data
        loadCachedData();


        // load remotely
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dc2fe12f.ngrok.io")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        StudentService service = retrofit.create(StudentService.class);

//        progressDialog = ProgressDialog.show(this, "Loading",
//                "Please wait...", true);
        Call<List<Student>> listCall = service.listAllStudents();
        listCall.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                //progressDialog.dismiss();
                students = response.body();
                ArrayAdapter<Student> arrayAdapter = 
                        new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, students);
                stuListView.setAdapter(arrayAdapter);
                // save the data locally
                Paper.book().write("stu-list-cache", students);
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                //progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed to get the list of students.", Toast.LENGTH_SHORT).show();
                Log.e("TEST", "Failed", t);
            }
        });

        stuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                intent.putExtra("id", students.get(i).getId());
                startActivity(intent);
            }
        });
    }

    private void loadCachedData() {
        students = Paper.book().read("stu-list-cache");
        if (students != null) {
            ArrayAdapter<Student> arrayAdapter =
                    new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, students);
            stuListView.setAdapter(arrayAdapter);
        }
    }
}
