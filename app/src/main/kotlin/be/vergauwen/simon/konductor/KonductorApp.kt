package be.vergauwen.simon.konductor

import android.app.Application
import com.squareup.leakcanary.BuildConfig
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

class KonductorApp : Application() {

    var refWatcher : RefWatcher? = null

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) refWatcher = LeakCanary.install(this)
    }

}