package com.tutorials.stars.data.network

import com.tutorials.stars.data.network.mapper.ApiMapper
import io.reactivex.Observable

class CocktailClientImpl(
    private val networkService: NetworkService,
    private val apiMapper: ApiMapper
) : CocktailClient {
    override fun getCocktails(): Observable<List<Cocktails?>> {
        return networkService.getListOfCocktails()
            .map { apiMapper.toCocktails(it) }
    }
}