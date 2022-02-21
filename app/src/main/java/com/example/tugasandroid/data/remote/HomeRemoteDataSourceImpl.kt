package com.example.tugasandroid.data.remote

import com.example.tugasandroid.data.service.HomeService
import com.example.tugasandroid.model.JobResponse
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.model.PostJobResponse
import com.example.tugasandroid.model.login.LoginResponse
import com.example.tugasandroid.model.requestlogin.RequestLogin
import io.reactivex.Single
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(private val service: HomeService) :
    HomeRemoteDataSource {

    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return service.postLogin(requestLogin)
    }

    override fun getJobs(): Single<JobResponse> {
        return service.getJobs()
    }

    override fun postJob(postJob: PostJob): Single<PostJobResponse> {
        return service.postJobs(postJob)
    }

}