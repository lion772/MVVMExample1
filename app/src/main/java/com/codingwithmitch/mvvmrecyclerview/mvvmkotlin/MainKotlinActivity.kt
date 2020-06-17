package com.codingwithmitch.mvvmrecyclerview.mvvmkotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingwithmitch.mvvmrecyclerview.R
import kotlinx.android.synthetic.main.activity_main_kotlin.*
import kotlinx.android.synthetic.main.places_dialog.view.*

class MainKotlinActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    private val adapter: RecyclerAdapterKotlin by lazy {
        RecyclerAdapterKotlin(emptyList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)

        setupRecyclerView()
        setupObservers()
        setupOnClickListener()

    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun setupOnClickListener() {

        floatingActionButton.setOnClickListener {
            showDialog()
        }
    }

    fun setupObservers() {

        viewModel.nicePlaces.observe(this, Observer { listNicePlace ->
            listNicePlace?.run {
                adapter.nicePlaces = listNicePlace
                adapter.notifyDataSetChanged()
            }


        }) //Observando os LiveDatas
        viewModel.isUpdating.observe(this, Observer { isVisible -> // Observer recebe um Boolean: isVisible

            isVisible?.run {
                if (isVisible)
                    progressBar.visibility = View.VISIBLE
                else
                    progressBar.visibility = View.GONE
            }

        })

    }

    fun showDialog() {

        val builder = AlertDialog.Builder(this)
        // Get the layout inflater
        val inflater = layoutInflater;

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        val view = inflater.inflate(R.layout.places_dialog, null)
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.add
                ) { _, _ ->
                    viewModel.addNewValue(
                            NicePlaceKotlin(
                                    view.placeUrl.text.toString(),
                                    view.placeName.text.toString()
                            )
                    )
                }
                .setNegativeButton(R.string.cancel
                ) { dialog, _ ->
                    dialog.cancel()
                }
        builder.create().show()
    }
}
