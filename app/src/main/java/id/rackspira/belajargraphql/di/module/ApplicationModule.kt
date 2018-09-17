package id.rackspira.belajargraphql.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import id.rackspira.belajargraphql.BaseApp
import id.rackspira.belajargraphql.di.scope.PerApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }

}