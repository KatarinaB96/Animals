package com.tutorials.stars.di.application

import com.tutorials.stars.base.TemplateApplication
import com.tutorials.stars.di.application.module.ApplicationModule
import com.tutorials.stars.di.application.module.DataModule
import com.tutorials.stars.di.application.module.MapperModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        DataModule::class,
        MapperModule::class
    ]
)
interface ApplicationComponent : ApplicationComponentInjects, ApplicationComponentExposes {
    object Initializer {
        fun init(templateApplication: TemplateApplication): ApplicationComponent =
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(templateApplication))
                .dataModule(DataModule())
                .mapperModule(MapperModule())
                .build()
    }
}