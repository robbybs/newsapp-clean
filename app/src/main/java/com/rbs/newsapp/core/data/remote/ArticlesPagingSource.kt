package com.rbs.newsapp.core.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rbs.newsapp.BuildConfig
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.data.remote.network.ApiService

class ArticlesPagingSource(private val query: String, private val apiService: ApiService) :
    PagingSource<Int, Articles>() {
    override fun getRefreshKey(state: PagingState<Int, Articles>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Articles> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getSearchArticles(query, position, params.loadSize, BuildConfig.KEY)
            LoadResult.Page(
                data = responseData.articles,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.articles.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}