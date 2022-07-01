package com.tutorials.stars.di.application

import com.tutorials.stars.di.application.module.ApplicationModule
import com.tutorials.stars.di.application.module.DataModule
import com.tutorials.stars.di.application.module.MapperModule

interface ApplicationComponentExposes : ApplicationModule.Exposes,
    DataModule.Exposes, MapperModule.Exposes

