package com.anwar.livecovid19.main


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings

import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.anwar.livecovid19.R
import com.anwar.livecovid19.checker.CheckFragment
import com.anwar.livecovid19.checker.CheckPresenter
import com.anwar.livecovid19.covidlist.view.CovidHomeFragment
import com.anwar.livecovid19.covidlist.presenter.CovidPresenter
import com.anwar.livecovid19.info.InfoFragment
import com.anwar.livecovid19.info.InfoPresenter
import com.dev.adnetworkm.CheckNetworkStatus
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(),MainView ,BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var buttonNavigation: BottomNavigationView

    val btn_ok = { dialog: DialogInterface, which: Int ->

        connectionreq()
        Toast.makeText(
            this,
            android.R.string.yes, Toast.LENGTH_SHORT
        ).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)

        buttonNavigation = findViewById(R.id.b_nav)


        buttonNavigation.setOnNavigationItemSelectedListener(this)
        buttonNavigation.selectedItemId = R.id.home

        connectionser()

    }



    fun connectionser(){
        CheckNetworkStatus.getNetworkLiveData(applicationContext).observe(this, Observer { t ->
            when (t) {
                true -> {
                    Toast.makeText(
                        this,
                        "Internet Connected", Toast.LENGTH_SHORT
                    ).show()

                    // TODO: Handle the connection...
                }
                false -> {

                    Toast.makeText(
                        this,
                        "No Internet Connection", Toast.LENGTH_SHORT
                    ).show()
                    // TODO: Handle the connection...

                    val builder = AlertDialog.Builder(this)

                    with(builder)
                    {
                        setTitle("ALERT!")
                        setMessage("No Internet Connection. Connect to the internet!")
                        setPositiveButton("Connect", DialogInterface.OnClickListener(function = btn_ok))
                        show()
                    }

                }
                null -> {
                    // TODO: Handle the connection...
                }
            }
        })
    }
    @Suppress("DEPRECATION")
    fun connectionreq() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
            startActivityForResult(panelIntent, 0)
        } else {

            (this.getSystemService(Context.WIFI_SERVICE) as? WifiManager)?.apply {
                isWifiEnabled = true /*or false*/
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home ->{
                val covidFragment =
                    CovidHomeFragment()
                loadFragment(covidFragment)
                CovidPresenter(
                    covidFragment
                )
                return true
            }
            R.id.check ->{
                val checkFragment = CheckFragment()
                loadFragment(checkFragment)
                CheckPresenter(checkFragment)
                return true
            }
            R.id.info ->{
                val infoFragment = InfoFragment()
                loadFragment(infoFragment)
                InfoPresenter(infoFragment)
                return true
            }
        }

        return false
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id._frame,fragment)
            .commit()
    }




}
