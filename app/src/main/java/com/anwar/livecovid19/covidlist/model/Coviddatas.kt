package com.anwar.livecovid19.covidlist.model

import com.google.gson.annotations.SerializedName

data class Coviddatas(
    @field:SerializedName("country_region")
    val country_region: String? = null,      // string? mean it can be null
    @field:SerializedName("countryflag") //urlToImage
    val countryflag: String? = null,
    @field:SerializedName("confirmed")
    val confirmed: String? = null,
    @field:SerializedName("deaths")
    val deaths: String? = null,
    @field:SerializedName("recovered")
    val recovered: String? = null,
    @field:SerializedName("last_updated")
    val last_updated: String? = null
)