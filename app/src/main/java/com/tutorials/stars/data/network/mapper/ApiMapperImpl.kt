package com.tutorials.stars.data.network.mapper

import com.tutorials.stars.data.network.CocktailResponse
import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.network.StrGlass
import io.reactivex.Observable
import kotlin.collections.List as List1

class ApiMapperImpl : ApiMapper {

    override fun toCocktails(response: CocktailResponse): kotlin.collections.List<Cocktails?> {
        return response.drinks.map {
            it.strGlass?.let { it1 -> Cocktails(it1) }
        }
    }

}