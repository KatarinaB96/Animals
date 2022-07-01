package com.tutorials.stars.data.network.mapper

import com.tutorials.stars.data.network.CocktailResponse
import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.network.StrGlass
import io.reactivex.Observable

interface ApiMapper {
    fun toCocktails(response: CocktailResponse): List<Cocktails?>
}