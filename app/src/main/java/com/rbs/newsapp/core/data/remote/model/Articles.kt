package com.rbs.newsapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @field:SerializedName("source")
    val source: SourceArticle? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @field:SerializedName("publishedAt")
    val publishedAt: String? = null
)