package com.example.tugasandroid.data.repository

import com.example.tugasandroid.model.JobResponse
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.model.PostJobResponse
import com.example.tugasandroid.model.login.LoginResponse
import com.example.tugasandroid.model.requestlogin.RequestLogin
import io.reactivex.Single

interface HomeRepository {

    fun getJobs(): Single<JobResponse>
    fun postJob(postJob: PostJob): Single<PostJobResponse>
    fun postLogin(requestLogin: RequestLogin):Single<LoginResponse>
}