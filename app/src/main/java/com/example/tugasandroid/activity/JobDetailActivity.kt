package com.example.tugasandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.tugasandroid.adapter.JobAdapter
import com.example.tugasandroid.databinding.ActivityJobDetailsBinding
import com.example.tugasandroid.databinding.ActivityLoginBinding
import com.example.tugasandroid.model.Data
import com.example.tugasandroid.model.PostJob
import com.example.tugasandroid.viewmodel.JobViewModel

class JobDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityJobDetailsBinding
//    private val adapter = JobAdapter()
    private val viewModel: JobViewModel by lazy {
        ViewModelProviders.of(this).get(JobViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.rvHasil.layoutManager = layoutManager
        viewModel.getJob()
//        binding.add.setOnClickListener{
//            viewModel.postJob(PostJob("test", "test", 123))
//        }
        setObserver()
    }

    private fun setObserver() {
        viewModel.listResponse().observe(this, Observer {
//            binding.rvHasil.adapter = adapter
            Log.d("teser", "if22")
//            adapter.initData(it.data as ArrayList<Data>)
        })
        viewModel.listPost().observe(this, Observer {
            viewModel.getJob()
        })
    }
}