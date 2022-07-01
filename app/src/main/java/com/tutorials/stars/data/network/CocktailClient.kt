package com.tutorials.stars.data.network

import io.reactivex.Observable

interface CocktailClient {
    fun getCocktails(): Observable<List<Cocktails?>>
}