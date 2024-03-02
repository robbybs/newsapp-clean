package com.rbs.newsapp.core.presentation.ui.search_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbs.newsapp.R
import com.rbs.newsapp.core.presentation.ui.WebViewActivity
import com.rbs.newsapp.core.presentation.utils.LoadingStateAdapter
import com.rbs.newsapp.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: SearchAdapter
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSearch.setOnClickListener {
                val query = tfSearch.editText?.text?.trim().toString()
                if (query.isEmpty()) {
                    Toast.makeText(
                        this@SearchActivity,
                        resources.getString(R.string.no_search),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    searchData(query)
                }
            }
        }
    }

    private fun searchData(query: String) {
        setAdapter()
        with(adapter) {
            viewModel.search(query).observe(this@SearchActivity) {
                submitData(lifecycle, it)
            }

            addLoadStateListener {
                if (it.append.endOfPaginationReached) {
                    if (itemCount < 1)
                        Toast.makeText(
                            this@SearchActivity,
                            resources.getString(R.string.no_data),
                            Toast.LENGTH_SHORT
                        ).show()
                }
            }

            setOnItemClickCallback(object : SearchAdapter.OnItemClickCallback {
                override fun onItemClicked(data: String) {
                    startActivity(
                        Intent(this@SearchActivity, WebViewActivity::class.java).putExtra(
                            WebViewActivity.URL,
                            data
                        )
                    )
                }
            })
        }
    }

    private fun setAdapter() {
        adapter = SearchAdapter()
        with(binding) {
            rvArticle.layoutManager = LinearLayoutManager(this@SearchActivity)
            rvArticle.adapter = adapter.withLoadStateFooter(
                footer = LoadingStateAdapter()
            )
        }
    }
}