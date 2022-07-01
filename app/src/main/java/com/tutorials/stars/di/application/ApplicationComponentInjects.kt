package com.tutorials.stars.di.application

import com.tutorials.stars.base.TemplateApplication

interface ApplicationComponentInjects {
    fun inject(application: TemplateApplication)
}