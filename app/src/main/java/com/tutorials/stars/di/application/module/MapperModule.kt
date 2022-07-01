package com.tutorials.stars.di.application.module

import com.tutorials.stars.data.crudder.DaoMapper
import com.tutorials.stars.data.crudder.DaoMapperImpl
import com.tutorials.stars.data.network.mapper.ApiMapper
import com.tutorials.stars.data.network.mapper.ApiMapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    fun daoMapper(): DaoMapper = DaoMapperImpl()

    @Provides
    @Singleton
    fun provideApiMapper(): ApiMapper = ApiMapperImpl()


    interface Exposes {
        fun daoMapper(): DaoMapper
        fun apiMapper(): ApiMapper
    }
}