package com.ssindher.bugfendertut

import android.app.Application
import com.bugfender.android.BuildConfig
import com.bugfender.sdk.Bugfender

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialise Bugfender
        Bugfender.init(this, "zxmxCqb0OZSticRkWIAr94u39nFUC2EO", BuildConfig.DEBUG)
        Bugfender.enableCrashReporting()
//        Bugfender.enableUIEventLogging(this)
//        Bugfender.enableLogcatLogging()
    }

}