package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.arch.lifecycle.MutableLiveData
import com.codingwithmitch.mvvmrecyclerview.models.NicePlace
import com.codingwithmitch.mvvmrecyclerview.repositories.NicePlaceRepository
import java.util.*

class PlacesRepository {


    private val instance: NicePlaceRepository? = null
    private val dataSet = ArrayList<NicePlace>()

    fun getNicePlaces(): MutableLiveData<List<NicePlace>>{
        setNicePlaces()
        var data = MutableLiveData<List<NicePlace>>()
        data.setValue(dataSet)
        return data
    }

    private fun setNicePlaces() {
        dataSet.add(
                NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        )
        dataSet.add(
                NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        )
        dataSet.add(
                NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        )
    }
}