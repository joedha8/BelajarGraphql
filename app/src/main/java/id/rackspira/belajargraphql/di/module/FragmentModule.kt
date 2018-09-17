package id.rackspira.belajargraphql.di.module

import dagger.Module
import dagger.Provides
import id.rackspira.belajargraphql.service.RetrofitService
import id.rackspira.belajargraphql.ui.fragment.retrofit.RetrofitContract
import id.rackspira.belajargraphql.ui.fragment.retrofit.RetrofitPresenter

@Module
class FragmentModule {

    @Provides
    fun provideApiService(): RetrofitService {
        return RetrofitService.create()
    }

    @Provides
    fun provideRetrofitPresenter(): RetrofitContract.Presenter {
        return RetrofitPresenter()
    }

}