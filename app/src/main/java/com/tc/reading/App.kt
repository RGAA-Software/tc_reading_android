package com.tc.reading

import android.app.Application

class App : Application() {

    private lateinit var appContext: AppContext

    override fun onCreate() {
        super.onCreate()
        appContext = AppContext(applicationContext)
    }

    public fun getAppContext(): AppContext {
        return appContext;
    }

}