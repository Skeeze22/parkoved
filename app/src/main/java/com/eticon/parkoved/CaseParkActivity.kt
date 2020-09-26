package com.eticon.parkoved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class CaseParkActivity : AppCompatActivity() {
    lateinit var rukami_lol: ConstraintLayout
    lateinit var geo: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_park)

        rukami_lol = findViewById(R.id.rukami_lol)
        geo = findViewById(R.id.geoposition)

        rukami_lol.setOnClickListener{
            val intent = Intent(this, CaseCityActivity::class.java)
            startActivity(intent)
        }

        geo.setOnClickListener{
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }

    }
}