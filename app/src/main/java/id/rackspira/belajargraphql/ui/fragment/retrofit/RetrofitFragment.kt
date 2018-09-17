package id.rackspira.belajargraphql.ui.fragment.retrofit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.rackspira.belajargraphql.R
import id.rackspira.belajargraphql.di.component.DaggerFragmentComponent
import id.rackspira.belajargraphql.di.module.FragmentModule
import id.rackspira.belajargraphql.model.Query
import id.rackspira.belajargraphql.model.Result
import id.rackspira.belajargraphql.service.QueryService
import kotlinx.android.synthetic.main.fragment_retrofit.*
import javax.inject.Inject

class RetrofitFragment : Fragment(), RetrofitContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: RetrofitContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this)
        presenter.subscribe()
        progress_bar.visibility = View.GONE

        btn_find.setOnClickListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.unsubscribe()

    }

    private fun injectDependency() {

        val listComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        listComponent.inject(this)

    }

    companion object {

        fun newInstance() = RetrofitFragment()

    }

    override fun showProgress(show: Boolean) {

        if (show)
            progress_bar.visibility = View.VISIBLE
        else
            progress_bar.visibility = View.GONE

    }

    override fun showError(error: String) {

        Toast.makeText(context, ""+error, Toast.LENGTH_SHORT).show()

    }

    override fun showResult(result: Result) {

        result_name.text = result!!.data!!.repository!!.name
        result_deskription.text = result!!.data!!.repository!!.description
        result_forks.text = "Total Forks : "+result!!.data!!.repository!!.forkCount
        result_url.text = "Url : \n"+result!!.data!!.repository!!.url

    }

    override fun onClick(p0: View?) {

        when (p0!!.id) {

            R.id.btn_find ->
                if (et_repo_name.text.isEmpty() && et_owner_name.text.isEmpty())
                    Toast.makeText(context, "Field Harus Diisi", Toast.LENGTH_SHORT).show()
                else
                    getInfoRepo(et_owner_name.text.toString(), et_repo_name.text.toString())

        }

    }

    fun getInfoRepo(ownerName: String, repoName: String) {

        progress_bar.visibility = View.VISIBLE

        val queryBody = Query()
        queryBody.query = QueryService().queryRepository(ownerName, repoName)

        presenter.getInfoRepository(queryBody)

    }
}
