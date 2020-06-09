package com.anwar.livecovid19.checker

import net.konyan.frameworkandextensions.framework.BasePresenter
import net.konyan.frameworkandextensions.framework.BaseView

interface CheckInterface {
    interface Presenter: BasePresenter{

    }

    interface View: BaseView<Presenter>{
        fun onShowText()
    }
}