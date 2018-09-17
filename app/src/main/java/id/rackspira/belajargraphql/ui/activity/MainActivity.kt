package id.rackspira.belajargraphql.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import id.rackspira.belajargraphql.R
import id.rackspira.belajargraphql.ui.fragment.retrofit.RetrofitFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        changeFragment(RetrofitFragment.newInstance())
    }

    private fun changeFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_fragment, fragment)
        fragmentTransaction.commit()
    }
}
