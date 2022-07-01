package com.tutorials.stars.di.application.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tutorials.stars.DeviceSharedPreferences
import com.tutorials.stars.data.crudder.Crudder
import com.tutorials.stars.data.network.CocktailClient
import com.tutorials.stars.data.network.CocktailClientImpl
import com.tutorials.stars.data.network.NetworkService
import com.tutorials.stars.data.network.mapper.ApiMapper
import com.tutorials.stars.domain.repository.AnimalRepository
import com.tutorials.stars.domain.repository.AnimalRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

        return builder.build()
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.thecocktaildb.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
    }


    @Provides
    @Singleton
    internal fun provideNetworkService(retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)

    @Provides
    @Singleton
    internal fun provideClient(
        networkService: NetworkService,
        apiMapper: ApiMapper
    ): CocktailClient {
        return CocktailClientImpl(networkService, apiMapper)
    }


    @Provides
    @Singleton
    internal fun provideRepository(
        deviceSharedPreferences: DeviceSharedPreferences,
        crudder: Crudder,
        cocktailClient: CocktailClient
    ): AnimalRepository {
        return AnimalRepositoryImpl(deviceSharedPreferences, crudder, cocktailClient)
    }

    interface Exposes {
        fun repositoryAnimal(): AnimalRepository
        fun provideClient(): CocktailClient
    }

}