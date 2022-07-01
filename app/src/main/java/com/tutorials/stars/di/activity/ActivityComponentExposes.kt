package com.tutorials.stars.di.activity

import com.tutorials.stars.di.activity.module.ActivityModule
import com.tutorials.stars.di.application.ApplicationComponentExposes
import com.tutorials.stars.router.module.RouterModule


interface ActivityComponentExposes : ActivityModule.Exposes, ApplicationComponentExposes,
    RouterModule.Exposes
