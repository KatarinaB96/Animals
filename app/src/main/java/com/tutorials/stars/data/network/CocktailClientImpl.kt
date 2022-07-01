package com.tutorials.stars.data.network

import com.tutorials.stars.data.network.mapper.ApiMapper
import io.reactivex.Observable

class CocktailClientImpl(private val networkService: NetworkService, private val apiMapper: ApiMapper) : CocktailClient {
    override fun getCocktails(): Observable<List<Cocktails?>> {
        return networkService.getListOfCocktails()
            .map { apiMapper.toCocktails(it) } // kad god čejnam nešto on uvijek vraća nešto što mora nastaviti chain (observable, complete), u ovom slučaju observable. map vraća Observable<Cat>
//            .map(apiMapper::toCats) // ovo je isto kao ovo gore je postoji samo jedan "it"
    }
}