package id.rackspira.belajargraphql.di.component

import dagger.Component
import id.rackspira.belajargraphql.BaseApp
import id.rackspira.belajargraphql.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}