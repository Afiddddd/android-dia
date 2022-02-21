package com.example.tugasandroid.data.repository

import com.example.tugasandroid.data.remote.HomeRemoteDataSource
import com.example.tugasandroid.model.JobResponse
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.model.PostJobResponse
import com.example.tugasandroid.model.login.LoginResponse
import com.example.tugasandroid.model.requestlogin.RequestLogin
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val remoteDataSource: HomeRemoteDataSource) :
    HomeRepository {

    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return remoteDataSource.postLogin(requestLogin)
    }

    override fun getJobs(): Single<JobResponse> {
        return remoteDataSource.getJobs()
    }

    override fun postJob(postJob: PostJob): Single<PostJobResponse> {
        return remoteDataSource.postJob(postJob)
    }
}