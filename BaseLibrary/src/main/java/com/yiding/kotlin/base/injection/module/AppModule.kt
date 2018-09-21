package com.yiding.kotlin.base.injection.module

import android.content.Context
import com.yiding.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

   @Provides
   @Singleton
   fun providesContext() : Context {
       return context
   }
}