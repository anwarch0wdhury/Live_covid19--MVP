package com.anwar.livecovid19.covidlist.presenter

import android.util.Log
import com.anwar.livecovid19.network.ClientInterface
import com.anwar.livecovid19.network.RetrofitInstance
import com.anwar.livecovid19.utils.enqueue


class CovidPresenter (_view: ViewInterface?):
    CovidPresInterface {

    var view: ViewInterface? = _view

    override fun processCall( name: String ) {


        val clientInterface =
            RetrofitInstance().retrofitInstance.create(
                ClientInterface::class.java) //ClientInterface =apiService

        val call = clientInterface.getItem(name) //

        // this is the extension function version of the callback enqueue

        call.enqueue {
            onResponse = {

                newsModel -> val newsModelRecords = newsModel.body()

                view?.onShowList(newsModelRecords!!)
            }
            onFailure = {
                    error -> Log.d("Fail", error?.message)
            }

        }//END CALL ENQUEUE
    }// END METHOD CALL

    override fun onDestroy() {
        view = null
    }

}