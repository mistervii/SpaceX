package com.msp.spacex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.msp.spacex.R
import com.msp.spacex.ui.adapters.LaunchesAdapter
import com.msp.spacex.utils.Results
import com.msp.spacex.utils.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var adapter = LaunchesAdapter(this)
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel : MainViewModel
    private lateinit var companyInfoTxtView : TextView
    private lateinit var refreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.launches_recyclerview)
        companyInfoTxtView = findViewById(R.id.company_description)
        refreshLayout = findViewById(R.id.refreshLayout)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()

        refreshLayout.setOnRefreshListener {
            loadData()
        }
    }

    fun loadData(){
        viewModel.getCompanyInfo().observe(this) { result ->
            when (result) {
                is Results.Success -> {
                    companyInfoTxtView.text = result.data.summary
                    refreshLayout.isRefreshing = false
                }
                is Results.Error -> {
                    // Handle the error
                }
                Results.Loading -> {
                    // Handle the loading state
                }
            }.exhaustive
        }
        viewModel.getAllLaunches().observe(this) { result ->
            when (result) {
                is Results.Success -> {
                    adapter.launches = result.data
                    adapter.notifyDataSetChanged()
                }
                is Results.Error -> {
                    // Handle the error
                }
                Results.Loading -> {
                    // Handle the loading state
                }
            }.exhaustive
        }
    }
}