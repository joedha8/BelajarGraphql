package id.rackspira.belajargraphql.di.component

import dagger.Component
import id.rackspira.belajargraphql.di.module.ActivityModule
import id.rackspira.belajargraphql.ui.activity.MainActivity

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}