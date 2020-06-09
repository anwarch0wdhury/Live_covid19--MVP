package com.anwar.livecovid19.covidlist.view

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anwar.livecovid19.R
import com.anwar.livecovid19.covidlist.model.CovidModel
import com.anwar.livecovid19.covidlist.model.Coviddatas
import com.anwar.livecovid19.utils.inflate
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recycler_view.view.*
import java.text.SimpleDateFormat
import java.util.*


class CovidAdapter (private val covidModel: CovidModel, private val listener: OnListClickLister):
    RecyclerView.Adapter<CovidAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = parent.inflate(R.layout.fragment_recycler_view, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  covidModel.articles!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(covidModel.articles!![position])

}

class ViewHolder (view: View): RecyclerView.ViewHolder(view){

    fun bind (coviddatas: Coviddatas) {
        itemView.tv_item_name.text = coviddatas.country_region
        Log.e("Country name :","${coviddatas.country_region}")
        itemView.tv_confirmed.text = coviddatas.confirmed
        itemView.tv_deaths.text = coviddatas.deaths
        itemView.tv_recovered.text = coviddatas.recovered



        fun getDateTime(s: String?): String? {
            return try {
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val netDate = Date(s!!.toLong()  )
                sdf.format(netDate)
            } catch (e: Exception) {
                e.toString()
            }
        }
        itemView.tv_udate.text = getDateTime(coviddatas.last_updated)

        val recov: String = coviddatas.recovered.toString()
        val deth: String = coviddatas.deaths.toString()
        val confir: String = coviddatas.confirmed.toString()

        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(confir.toFloat()))
        yVals.add(PieEntry(deth.toFloat()))
        yVals.add(PieEntry(recov.toFloat()))

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize=0f
        val colors = ArrayList<Int>()
        colors.add(Color.parseColor("#1E90FF"))
        colors.add(Color.parseColor("#15E0E6"))
        colors.add(Color.parseColor("#191970"))


        dataSet.setColors(colors)

        val data = PieData(dataSet)
        itemView.pieChart.data = data
        itemView.pieChart.centerTextRadiusPercent = 0f
        itemView.pieChart.isDrawHoleEnabled = true
        itemView.pieChart.legend.isEnabled = false
        itemView.pieChart.description.isEnabled = false





        Picasso.get().load(coviddatas.countryflag).into(itemView.iv_item_layout_image_recycler)


    }


}
}

interface OnListClickLister{

    fun onListClick(coviddatas: Coviddatas)
}