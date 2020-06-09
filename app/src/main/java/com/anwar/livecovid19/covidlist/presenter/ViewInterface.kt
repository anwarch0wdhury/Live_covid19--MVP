package com.anwar.livecovid19.covidlist.presenter

import com.anwar.livecovid19.covidlist.model.CovidModel

interface ViewInterface {

    fun showProgress()
    fun showError()
    fun onShowList(covidModel: CovidModel)


}