package com.eticon.parkoved

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity() {

    lateinit  var bottomNavigator: BottomNavigationView
    lateinit var context: Context
    lateinit var layoutFragment: FrameLayout

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
        val ticketFragmement = TicketFragment()

        bottomNavigator.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{  MenuItem ->
            when(MenuItem.itemId){
                R.id.map -> {
                    supportFr.beginTransaction().replace(R.id.fl_content, mapFragment).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ticket ->{
                    return@OnNavigationItemSelectedListener true
                }
                R.id.skaner -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.routes->{
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
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