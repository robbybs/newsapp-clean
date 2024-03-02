package com.rbs.newsapp.core.presentation.ui.home_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbs.newsapp.R
import com.rbs.newsapp.core.presentation.ui.search_screen.SearchActivity
import com.rbs.newsapp.core.presentation.ui.source_screen.SourceNewsActivity
import com.rbs.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        search()
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MainAdapter()
        with(binding.rvCategory) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
        setData(adapter)
    }

    private fun setData(adapter: MainAdapter) {
        val data = resources.getStringArray(R.array.category)
        with(viewModel)
        {
            getData(data)

            category.observe(this@MainActivity) {
                adapter.submitList(it)
            }
        }

        adapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: String) {
                startActivity(
                    Intent(this@MainActivity, SourceNewsActivity::class.java).putExtra(
                        SourceNewsActivity.CATEGORY,
                        data
                    )
                )
            }
        })
    }

    private fun search() {
        binding.fabSearch.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, SearchActivity::class.java)
            )
        }
    }
}