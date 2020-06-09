package com.anwar.livecovid19.covidlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import androidx.recyclerview.widget.LinearLayoutManager
import com.anwar.livecovid19.*
import com.anwar.livecovid19.covidlist.model.CovidModel
import com.anwar.livecovid19.covidlist.model.Coviddatas
import com.anwar.livecovid19.covidlist.presenter.CovidPresenter
import com.anwar.livecovid19.covidlist.presenter.ViewInterface


import kotlinx.android.synthetic.main.fragment_covid.*


class CovidHomeFragment : Fragment(),
    ViewInterface {

    private lateinit var covidPresenter: CovidPresenter
    lateinit var search: EditText

    override fun showProgress() {
        prgs_bar.visibility = View.VISIBLE
    }

    override fun showError() {
    }

    override fun onShowList(covidModel: CovidModel) {

        prgs_bar.visibility = View.GONE

        val adapter: CovidAdapter =
            CovidAdapter(
                covidModel,
                object : OnListClickLister {

                    override fun onListClick(coviddatas: Coviddatas) {


                    }//END ONLISTCLICK METHOD
                })//END ADAPTER INITIALIZATION

        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = adapter
    }

    override fun onDestroy() { // this is the activity's onDestroy() method call
        super.onDestroy()
        covidPresenter.onDestroy()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        covidPresenter =
            CovidPresenter(this)



        iv_search.setOnClickListener {

            val inputValue: String = tv_main_search.text.toString()
            if ( inputValue.trim() == "") {
                covidPresenter.processCall("")
                showProgress()
            } else {
                covidPresenter.processCall(inputValue)
                showProgress()
            }


        }
        covidPresenter.processCall("")
        showProgress()

    }
}


