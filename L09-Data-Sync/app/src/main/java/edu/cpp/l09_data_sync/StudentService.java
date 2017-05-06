package edu.cpp.l09_data_sync;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yusun on 5/3/17.
 */

public interface StudentService {

    @GET("/list/students")
    Call<List<Student>> listAllStudents();
}
