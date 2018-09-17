package id.rackspira.belajargraphql.ui.fragment.retrofit

import id.rackspira.belajargraphql.model.Result
import id.rackspira.belajargraphql.model.Query
import id.rackspira.belajargraphql.service.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RetrofitPresenter: RetrofitContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: RetrofitService = RetrofitService.create()
    private lateinit var view: RetrofitContract.View

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: RetrofitContract.View) {
        this.view = view
    }

    override fun getInfoRepository(jsonQuery: Query) {

        val subscribe = api.getInfo(jsonQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result: Result? ->
                    view.showProgress(false)
                    if (result != null)
                        view.showResult(result)
                }, { t: Throwable? ->
                    view.showProgress(false)
                    view.showError(t.toString())
                })

        subscriptions.add(subscribe)

    }
}