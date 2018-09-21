package com.yiding.kotlin.base.injection.module

import android.app.Activity
import com.yiding.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: Activity) {

   @ActivityScope
   @Provides
   fun providesActivity() : Activity {
       return this.activity
   }
}