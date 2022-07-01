package com.tutorials.stars.di.activity.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentManager
import com.tutorials.stars.base.BaseActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val baseActivity: BaseActivity) {

    @Provides
    internal fun provideActivity(): Activity {
        return baseActivity
    }

    @Provides
    internal fun provideFragmentManager(): FragmentManager {
        return baseActivity.supportFragmentManager
    }


//    @Provides
//    @ActivityScope
//    internal fun provideLayoutInflater(context: Context): LayoutInflater {
//        return LayoutInflater.from(context)
//    }

    //this is for navigation

//    @Provides
//    @ActivityScope
//    internal fun provideRouter(fragmentManager: FragmentManager): Router {
//        return RouterImpl(daggerActivity, fragmentManager)
//    }


    interface Exposes {

        fun activity(): Activity

        fun context(): Context

        fun fragmentManager(): FragmentManager

//        fun layoutInflater(): LayoutInflater

    }
}