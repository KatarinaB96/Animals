package com.tutorials.stars.data.network

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("drinks")
    val drinks: List<StrGlass>
)