package com.tutorials.stars.di.activity

import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.di.activity.module.ActivityModule
import com.tutorials.stars.di.application.ApplicationComponent
import com.tutorials.stars.di.scopes.ActivityScope
import com.tutorials.stars.router.module.RouterModule
import dagger.Component


@ActivityScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [
        ActivityModule::class,
        RouterModule::class
    ]
)

interface ActivityComponent : ActivityComponentInjects, ActivityComponentExposes {

    object Initializer {
        fun init(
            baseActivity: BaseActivity,
            applicationComponent: ApplicationComponent
        ): ActivityComponent =
            DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(baseActivity))
                .routerModule(RouterModule(baseActivity))
//                .activityViewModelModule(ActivityViewModelModule(baseActivity))
                .build()
    }
}