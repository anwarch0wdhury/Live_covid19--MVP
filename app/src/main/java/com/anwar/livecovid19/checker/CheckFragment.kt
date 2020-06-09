package com.anwar.livecovid19.checker

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anwar.livecovid19.R
import kotlinx.android.synthetic.main.fragment_check.view.*


class CheckFragment: Fragment(), CheckInterface.View {
    override lateinit var presenter: CheckInterface.Presenter


    val btn_ok = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            activity,
            android.R.string.yes, Toast.LENGTH_SHORT
        ).show()
    }

    override fun onShowText() {

    }

    fun posetiveAlert() {

        val builder = AlertDialog.Builder(activity)

        with(builder)
        {
            setTitle("Advice")
            setMessage(getString(R.string.posetive_decision))
            setPositiveButton("OK", DialogInterface.OnClickListener(function = btn_ok))

            show()
        }


    }

    fun negativeAlert() {

        val builder = AlertDialog.Builder(activity)

        with(builder)
        {
            setTitle("Advice")
            setMessage(getString(R.string.negative_decision))
            setPositiveButton("OK", DialogInterface.OnClickListener(function = btn_ok))

            show()
        }


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.fragment_check,container,false)
        with(view){

            btn_check.setOnClickListener {
                val s_old : Int? = et_old.toString().toIntOrNull()
                if (s_old != null) {
                    if(s_old > 40){

                        if (checkBox1.isChecked && checkBox5.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                            posetiveAlert()
                        }
                       else if (checkBox1.isChecked && checkBox2.isChecked && checkBox4.isChecked && checkBox6.isChecked && checkBox8.isChecked ) {

                            posetiveAlert()
                        }
                        else if ( checkBox2.isChecked && checkBox4.isChecked && checkBox6.isChecked && checkBox8.isChecked ) {

                            posetiveAlert()
                        }

                        else if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox5.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                            posetiveAlert()
                        }
                    } else if(s_old > 20){
                        if (checkBox1.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox6.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                            posetiveAlert()
                        } else if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked && checkBox6.isChecked && checkBox7.isChecked && checkBox8.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                            posetiveAlert()
                        }
                    } else if (s_old<17){
                        if (checkBox9.isChecked && checkBox11.isChecked ){
                           posetiveAlert()
                        }
                        else if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox9.isChecked && checkBox11.isChecked ){
                            posetiveAlert()
                        }
                        else if (checkBox5.isChecked && checkBox7.isChecked && checkBox8.isChecked && checkBox9.isChecked && checkBox11.isChecked ){
                            posetiveAlert()
                        }
                        else{
                            negativeAlert()
                        }
                    }
                    else{
                        negativeAlert()
                    }
                }
                else{
                    if (checkBox1.isChecked && checkBox5.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                        posetiveAlert()
                    } else if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox5.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                        posetiveAlert()
                    }
                    else if (checkBox1.isChecked && checkBox4.isChecked && checkBox2.isChecked && checkBox9.isChecked && checkBox11.isChecked && checkBox5.isChecked) {

                        posetiveAlert()
                    }
                    else if (checkBox1.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox6.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                        posetiveAlert()
                    } else if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked && checkBox6.isChecked && checkBox7.isChecked && checkBox8.isChecked && checkBox9.isChecked && checkBox11.isChecked) {

                        posetiveAlert()
                    }
                    else if (checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked && checkBox8.isChecked && checkBox9.isChecked ) {

                        posetiveAlert()
                    }
                    else if (checkBox1.isChecked && checkBox8.isChecked && checkBox9.isChecked && checkBox11.isChecked ) {

                        posetiveAlert()
                    }
                    else{
                        negativeAlert()
                    }
                }

            }


        }
        return view
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun setLoading(active: Boolean) {

    }

    override fun showMessage(message: Int) {

    }

    companion object {
        fun newInstance()= CheckFragment()
    }
}