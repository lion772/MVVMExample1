package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.AsyncTask
import com.codingwithmitch.mvvmrecyclerview.models.NicePlace
import com.codingwithmitch.mvvmrecyclerview.repositories.NicePlaceRepository

class MainViewModel : ViewModel() { //Estendendo

    private val _nicePlaces = MutableLiveData<List<NicePlaceKotlin>>() //declarar e instanciar a variável
    val nicePlaces: LiveData<List<NicePlaceKotlin>>
    get() = _nicePlaces

    private val _isUpdating = MutableLiveData<Boolean>()
    val isUpdating: LiveData<Boolean>
    get() = _isUpdating

    init {
        _nicePlaces.value = PlacesRepository.getNicePlacesList()
    }

    fun addNewValue(nicePlace: NicePlaceKotlin) {
        _isUpdating.value = true
        PlacesRepository.addNicePlaceToList(nicePlace) //adiciona o atributo para atualizar
        _nicePlaces.value = PlacesRepository.getNicePlacesList() //mesmo processo do init, porém atualiza-se antes de recuperar
        _isUpdating.value = false
    }
}