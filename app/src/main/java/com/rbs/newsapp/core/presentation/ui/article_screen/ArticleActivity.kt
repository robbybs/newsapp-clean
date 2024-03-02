package com.rbs.newsapp.core.presentation.ui.article_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbs.newsapp.core.presentation.ui.WebViewActivity
import com.rbs.newsapp.databinding.ActivityArticleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding
    private val viewModel: ArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sources = intent.getStringExtra(SOURCES).toString()
        setAdapter(sources, viewModel)
    }

    private fun setAdapter(sources: String, viewModel: ArticleViewModel) {
        val adapter = ArticleAdapter()
        with(binding.rvArticle) {
            layoutManager = LinearLayoutManager(this@ArticleActivity)
            this.adapter = adapter
        }

        with(viewModel) {
            getArticles(sources).observe(this@ArticleActivity) {
                setDataVisible()
                adapter.submitList(it)
            }
        }

        adapter.setOnItemClickCallback(object : ArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: String) {
                startActivity(
                    Intent(this@ArticleActivity, WebViewActivity::class.java).putExtra(
                        WebViewActivity.URL,
                        data
                    )
                )
            }
        })
    }

    private fun setDataVisible() {
        with(binding) {
            progressCircular.visibility = View.GONE
            rvArticle.visibility = View.VISIBLE
        }
    }

    companion object {
        const val SOURCES = "sources"
    }
}