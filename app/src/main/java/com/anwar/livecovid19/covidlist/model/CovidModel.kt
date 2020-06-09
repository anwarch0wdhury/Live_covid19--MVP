package com.anwar.livecovid19.covidlist.model


import com.anwar.livecovid19.covidlist.model.Coviddatas
import com.google.gson.annotations.SerializedName

data class CovidModel (


	@SerializedName("results") val articles: List<Coviddatas>? = null
)