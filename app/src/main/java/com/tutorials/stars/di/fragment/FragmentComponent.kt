package com.tutorials.stars.di.fragment


import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.di.activity.ActivityComponent
import com.tutorials.stars.di.fragment.module.FragmentMapperModule
import com.tutorials.stars.di.fragment.module.FragmentModule
import com.tutorials.stars.di.fragment.module.FragmentViewModelModule
import com.tutorials.stars.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [
        FragmentModule::class,
        FragmentViewModelModule::class,
        FragmentMapperModule::class
    ]
)


interface FragmentComponent : FragmentComponentInjects, FragmentComponentExposes {
    object Initializer {
        fun init(
            baseActivity: BaseActivity,
            baseFragment: BaseFragment,
            activityComponent: ActivityComponent
        ): FragmentComponent =
            DaggerFragmentComponent.builder().activityComponent(activityComponent)
                .fragmentModule(FragmentModule(baseFragment))
                .fragmentMapperModule(FragmentMapperModule())
                .fragmentViewModelModule(FragmentViewModelModule(baseActivity))
                .build()
    }


}