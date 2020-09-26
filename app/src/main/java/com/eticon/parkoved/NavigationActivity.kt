package com.eticon.parkoved

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity() {

    lateinit var bottomNavigator: BottomNavigationView
    lateinit var context: Context
    lateinit var layoutFragment: FrameLayout
    //lateinit var supportFr: supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        context = this

        initViews()
        val supportFr = supportFragmentManager
        val content = supportFr.findFragmentById(R.id.fl_content)



        if (content == null){
            val fragment = MapFragment()
            supportFr.beginTransaction().add(R.id.fl_content , fragment).commit()
        }

        val mapFragment = MapFragment()
        val ticketFragment = TicketFragment()
        val scanerFragment = SkanerFragment()
        val routesFragment = RoutesFragment()
        val profileFragment = ProfileFragment()

        bottomNavigator.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{  MenuItem ->
            when(MenuItem.itemId){
                R.id.map -> {
                    supportFr.beginTransaction().replace(R.id.fl_content, mapFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ticket ->{
                    supportFr.beginTransaction().replace(R.id.fl_content, ticketFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.skaner -> {
                    supportFr.beginTransaction().replace(R.id.fl_content, scanerFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.routes->{
                    supportFr.beginTransaction().replace(R.id.fl_content, routesFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    supportFr.beginTransaction().replace(R.id.fl_content, profileFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener true
            }
        }

    }


    fun initViews(){
        bottomNavigator = findViewById(R.id.navigation)
        layoutFragment = findViewById(R.id.fl_content)
    }

}