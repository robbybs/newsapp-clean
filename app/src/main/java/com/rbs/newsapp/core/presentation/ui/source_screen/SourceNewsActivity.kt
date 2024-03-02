package com.rbs.newsapp.core.presentation.ui.source_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbs.newsapp.core.presentation.ui.article_screen.ArticleActivity
import com.rbs.newsapp.databinding.ActivitySourceNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySourceNewsBinding
    private val viewModel: SourceNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra(CATEGORY).toString()
        setAdapter(category, viewModel)
    }

    private fun setAdapter(category: String, viewModel: SourceNewsViewModel) {
        val adapter = SourceAdapter()
        with(binding.rvSource) {
            layoutManager = LinearLayoutManager(this@SourceNewsActivity)
            this.adapter = adapter
        }

        with(viewModel) {
            getSources(category).observe(this@SourceNewsActivity) {
                setDataVisible()
                adapter.submitList(it)
            }
        }

        adapter.setOnItemClickCallback(object : SourceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: String) {
                startActivity(
                    Intent(this@SourceNewsActivity, ArticleActivity::class.java).putExtra(
                        ArticleActivity.SOURCES,
                        data
                    )
                )
            }
        })
    }

    private fun setDataVisible() {
        with(binding) {
            progressCircular.visibility = View.GONE
            rvSource.visibility = View.VISIBLE
        }
    }

    companion object {
        const val CATEGORY = "category"
    }
}