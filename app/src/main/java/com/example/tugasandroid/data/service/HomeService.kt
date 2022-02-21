package com.example.tugasandroid.data.service

import com.example.tugasandroid.model.JobResponse
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.model.PostJobResponse
import com.example.tugasandroid.model.login.LoginResponse
import com.example.tugasandroid.model.requestlogin.RequestLogin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeService {

    @POST("api/v1/user/login")
    fun postLogin(@Body requestLogin: RequestLogin):Single<LoginResponse>

    @GET("/api/v1/jobs")
    fun getJobs(): Single<JobResponse>
    @POST("api/v1/job/body")
    fun postJobs(@Body postjob: PostJob): Single<PostJobResponse>
}