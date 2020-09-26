package com.eticon.parkoved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CaseCityActivity : AppCompatActivity() {

    lateinit var backBtn: ImageView
    lateinit var lipetsk: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_city)

        backBtn = findViewById(R.id.back_btn)
        lipetsk = findViewById(R.id.lipetsk)

        backBtn.setOnClickListener {
            finish()
        }

        lipetsk.setOnClickListener {
            val intent = Intent(this, CaseParkInCityActivity::class.java)
            startActivity(intent)
        }

    }
}