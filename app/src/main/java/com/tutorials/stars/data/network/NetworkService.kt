package com.tutorials.stars.data.network

import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkService {
    @GET("/api/json/v1/1/list.php?g=list")
    fun getListOfCocktails(): Observable<CocktailResponse>
}