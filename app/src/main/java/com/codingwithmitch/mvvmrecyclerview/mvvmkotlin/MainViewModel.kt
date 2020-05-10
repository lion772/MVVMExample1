package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.codingwithmitch.mvvmrecyclerview.models.NicePlace
import com.codingwithmitch.mvvmrecyclerview.repositories.NicePlaceRepository

class MainViewModel : ViewModel() {

    private val _nicePlaces = MutableLiveData<List<NicePlace>>() //declarar e instanciar a variável
    val nicePlaces: LiveData<List<NicePlace>>
    get() = _nicePlaces

    private val _isUpdating = MutableLiveData<Boolean>()
    val isUpdating: LiveData<Boolean>
    get() = _isUpdating

    private val repo = NicePlaceRepository()
}