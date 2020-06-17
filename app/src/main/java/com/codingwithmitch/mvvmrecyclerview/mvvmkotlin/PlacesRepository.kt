package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin


import java.util.*

object PlacesRepository {

    private var dataSet = ArrayList<NicePlaceKotlin>()

    init {
        setNicePlaceKotlins()
    }

    fun addNicePlaceToList(place: NicePlaceKotlin){
        dataSet.add(place)
    }

    fun getNicePlacesList(): List<NicePlaceKotlin> {
        return dataSet
    }

    private fun setNicePlaceKotlins() {

        dataSet = arrayListOf(
                        NicePlaceKotlin("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls"),
                        NicePlaceKotlin("https://i.redd.it/tpsnoz5bzo501.jpg",
                                "Trondheim"),
                        NicePlaceKotlin("https://i.redd.it/tpsnoz5bzo501.jpg",
                                "Trondheim"),
                        NicePlaceKotlin("https://i.redd.it/qn7f9oqu7o501.jpg",
                                "Portugal"),
                        NicePlaceKotlin("https://i.redd.it/j6myfqglup501.jpg",
                                "Rocky Mountain National Park"),
                        NicePlaceKotlin("https://i.redd.it/0h2gm1ix6p501.jpg",
                                "Havasu Falls"),
                        NicePlaceKotlin("https://i.redd.it/k98uzl68eh501.jpg",
                                "Mahahual"),
                        NicePlaceKotlin("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                                "Frozen Lake"),
                        NicePlaceKotlin("https://i.redd.it/obx4zydshg601.jpg",
                                "Austrália")
        )
    }
}