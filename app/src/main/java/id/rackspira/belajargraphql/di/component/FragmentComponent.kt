package id.rackspira.belajargraphql.di.component

import dagger.Component
import id.rackspira.belajargraphql.di.module.FragmentModule
import id.rackspira.belajargraphql.ui.fragment.retrofit.RetrofitFragment

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(retrofitFragment: RetrofitFragment)

}