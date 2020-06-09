package com.anwar.livecovid19.info

import com.anwar.livecovid19.info.InfoInterface

class InfoPresenter(private var view: InfoInterface.View): InfoInterface.Presenter {

    init {
        view.presenter=this
    }

    override fun start() {
        loadData()
    }

    private fun loadData(){
        view.onShowText()
    }
}