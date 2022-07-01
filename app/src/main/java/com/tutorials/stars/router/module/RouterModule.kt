package com.tutorials.stars.router.module

import androidx.fragment.app.FragmentManager
import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.router.Router
import com.tutorials.stars.router.RouterImpl
import dagger.Module
import dagger.Provides


@Module
class RouterModule(private val baseActivity: BaseActivity) {

    @Provides
    internal fun provideRouter(fragmentManager: FragmentManager): Router {
        return RouterImpl(fragmentManager)
    }


    interface Exposes {
        fun router(): Router
    }
}