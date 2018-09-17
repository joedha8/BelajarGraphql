package id.rackspira.belajargraphql.ui.fragment.retrofit

import id.rackspira.belajargraphql.base.BaseContract
import id.rackspira.belajargraphql.model.Result
import id.rackspira.belajargraphql.model.Query

class RetrofitContract {

    interface View: BaseContract.View {

        fun showProgress(show: Boolean)

        fun showError(error: String)

        fun showResult(result: Result)

    }

    interface Presenter: BaseContract.Presenter<View> {

        fun getInfoRepository(jsonQuery: Query)

    }

}