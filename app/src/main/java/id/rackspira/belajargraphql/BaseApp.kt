package id.rackspira.belajargraphql

import android.app.Application
import id.rackspira.belajargraphql.di.component.ApplicationComponent
import id.rackspira.belajargraphql.di.component.DaggerApplicationComponent
import id.rackspira.belajargraphql.di.module.ApplicationModule

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}