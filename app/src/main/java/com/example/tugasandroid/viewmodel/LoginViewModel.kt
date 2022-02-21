package com.example.tugasandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugasandroid.data.di.DaggerHomeComponent
import com.example.tugasandroid.data.repository.HomeRepository
import com.example.tugasandroid.model.JobResponse
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.model.PostJobResponse
import com.example.tugasandroid.model.login.LoginResponse
import com.example.tugasandroid.model.requestlogin.RequestLogin
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class LoginViewModel: ViewModel() {
    private val list = MutableLiveData<LoginResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val isError = MutableLiveData<Boolean>()



    @Inject
    lateinit var repository: HomeRepository

    init {
        DaggerHomeComponent.create().injectLogin(this)
    }


    fun postLogin(requestLogin: RequestLogin){
        compositeDisposable.add(
            repository.postLogin(requestLogin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
                    override fun onSuccess(t: LoginResponse) {
                        if (t.code == 200) {
                            list.value = t
                            Log.d("test123", "gaerror =  " + t.toString())
                        } else {
                            isError.value = true

                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d("test123", "error =  " + e.toString())
                        isError.value = true
                        if (e is HttpException) {
                            val errorBody = (e as HttpException).response()?.errorBody()
                            val gson = Gson()
                            val error = gson.fromJson(
                                errorBody?.string(),
                                LoginResponse::class.java
                            )
                            Log.d("test123", "error =  " + error)

                        }
                    }
                })
        )
    }

    fun listResponse(): MutableLiveData<LoginResponse> {
        return list
    }

    fun getIsError(): MutableLiveData<Boolean> {
        return isError
    }
}