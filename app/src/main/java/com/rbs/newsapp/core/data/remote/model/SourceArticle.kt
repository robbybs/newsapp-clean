package com.rbs.newsapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class SourceArticle(
    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)
