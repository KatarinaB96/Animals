package com.tutorials.stars.di.fragment

import com.tutorials.stars.di.activity.ActivityComponentExposes
import com.tutorials.stars.di.fragment.module.FragmentMapperModule
import com.tutorials.stars.di.fragment.module.FragmentModule


interface FragmentComponentExposes : FragmentModule.Exposes, ActivityComponentExposes, FragmentMapperModule.Exposes