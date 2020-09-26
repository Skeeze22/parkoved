package com.eticon.parkoved.Personal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.eticon.parkoved.R
import com.google.android.material.bottomnavigation.BottomNavigationView

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
}