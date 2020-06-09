package com.anwar.livecovid19.info

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.anwar.livecovid19.R


class InfoFragment: Fragment(), InfoInterface.View {
    override lateinit var presenter: InfoInterface.Presenter
    lateinit var tv_infotitle: TextView

    override fun onShowText() {
        tv_infotitle.text=getString(R.string.tv_covid19)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.fragment_info,container,false)
        with(view){
            tv_infotitle= findViewById(R.id.tv_infotitle)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun setLoading(active: Boolean) {

    }

    override fun showMessage(message: Int) {

    }

    companion object {
        fun newInstance()= InfoFragment()
    }
}