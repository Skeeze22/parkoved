package com.eticon.parkoved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CaseParkInCityActivity : AppCompatActivity() {

    lateinit var backBtn: ImageView
    lateinit var park: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_park_in_city)

        backBtn = findViewById(R.id.back_btn)
        park = findViewById(R.id.park)

        backBtn.setOnClickListener {
            finish()
        }

        park.setOnClickListener {
            val intent =  Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }

    }
}