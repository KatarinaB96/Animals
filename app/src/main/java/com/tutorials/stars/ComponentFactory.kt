package com.tutorials.stars

import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.base.TemplateApplication
import com.tutorials.stars.di.activity.ActivityComponent
import com.tutorials.stars.di.application.ApplicationComponent
import com.tutorials.stars.di.fragment.FragmentComponent

object ComponentFactory {
    fun createApplicationComponent(templateApplication: TemplateApplication): ApplicationComponent {
        return ApplicationComponent.Initializer.init(templateApplication)
    }

    fun createActivityComponent(baseActivity: BaseActivity, applicationComponent: ApplicationComponent): ActivityComponent {
        return ActivityComponent.Initializer.init(baseActivity, applicationComponent)
    }

    fun createFragmentComponent(baseActivity: BaseActivity,baseFragment: BaseFragment, activityComponent: ActivityComponent): FragmentComponent {
        return FragmentComponent.Initializer.init( baseActivity,baseFragment,activityComponent)
    }
}