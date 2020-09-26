package com.eticon.parkoved.Personal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eticon.parkoved.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.zxing.integration.android.IntentIntegrator


class PersonalNavigator : AppCompatActivity() {
    lateinit var navigator: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_navigator)
        navigator = findViewById(R.id.navigation_pers)
        var sp = supportFragmentManager
        var content = sp.findFragmentById(R.id.fl_personal)
        if (content == null) {
            sp.beginTransaction().replace(R.id.fl_personal, NewsFragment()).commit()
        }
        navigator.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ MenuItem ->
            when (MenuItem.itemId) {
                R.id.news -> {
                    sp.beginTransaction().replace(R.id.fl_personal, NewsFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.kassa -> {
                    sp.beginTransaction().replace(R.id.fl_personal, PersonKassaFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.skaner -> {
                    sp.beginTransaction().replace(R.id.fl_personal, PersonalScanerFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.message->{
                    sp.beginTransaction().replace(R.id.fl_personal, MessagePersonalFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener false
            }
        }

    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        var fragment = findViewById<FrameLayout>(R.id.fl_personal)
        val args = Bundle()
        if (result != null) {
            if (result.contents == null) {
               args.putString("Bilet", "Билет не действителен")
                fragment.findViewById<TextView>(R.id.text_mess).text = "Билет не действителен"
                fragment.findViewById<TextView>(R.id.text_mess).setTextColor(getColor(R.color.red))
            } else {
                if (result.contents == "Билет действителен"){
                    Log.d("RES2", "1")
                    fragment.findViewById<TextView>(R.id.text_mess).text = "Билет  действителен"
                    fragment.findViewById<TextView>(R.id.text_mess).setTextColor(getColor(R.color.green))
                }
                else{
                    fragment.findViewById<TextView>(R.id.text_mess).text = "Билет не действителен"
                    fragment.findViewById<TextView>(R.id.text_mess).setTextColor(getColor(R.color.red))
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
 /*   override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }*/
}