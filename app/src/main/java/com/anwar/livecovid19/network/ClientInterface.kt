package com.anwar.livecovid19.network


import com.anwar.livecovid19.covidlist.model.CovidModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientInterface {
    @GET("coviddatas.php")
    fun getItem(
        @Query ("q") q: String
    ):  Call<CovidModel>
}




