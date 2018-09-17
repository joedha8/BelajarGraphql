package id.rackspira.belajargraphql.service

import id.rackspira.belajargraphql.BuildConfig
import id.rackspira.belajargraphql.model.Query
import id.rackspira.belajargraphql.model.Result
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    @Headers("Authorization:Bearer "+BuildConfig.TOKEN)
    @POST("graphql")
    fun getInfo(@Body jsonQuery: Query): Observable<Result>

    companion object {

        fun create(): RetrofitService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()

            return retrofit.create(RetrofitService::class.java)
        }

    }
}