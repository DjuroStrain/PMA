package com.example.durobelacic.lv1_faks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenCoursesApiService {

    @GET("v1/courses")
    Call<ApiResponse> getCourses();
}
