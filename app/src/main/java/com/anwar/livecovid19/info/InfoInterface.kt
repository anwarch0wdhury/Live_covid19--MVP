package com.anwar.livecovid19.info


import net.konyan.frameworkandextensions.framework.BasePresenter
import net.konyan.frameworkandextensions.framework.BaseView

interface InfoInterface {
    interface Presenter: BasePresenter{

    }

    interface View: BaseView<Presenter>{
        fun onShowText()
    }
}