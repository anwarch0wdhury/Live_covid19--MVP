package com.anwar.livecovid19.checker

import com.anwar.livecovid19.checker.CheckInterface

class CheckPresenter(private var view: CheckInterface.View): CheckInterface.Presenter {

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