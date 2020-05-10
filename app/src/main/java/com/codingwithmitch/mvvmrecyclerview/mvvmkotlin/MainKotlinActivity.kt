package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import com.codingwithmitch.mvvmrecyclerview.R
import com.codingwithmitch.mvvmrecyclerview.adapters.RecyclerAdapter
import com.codingwithmitch.mvvmrecyclerview.viewmodels.MainActivityViewModel

class MainKotlinActivity : AppCompatActivity() {

    private val mMainActivityViewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)


    }
}
