package com.rbs.newsapp.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class SourcesResponse(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("sources")
    val sources: List<Sources>
)