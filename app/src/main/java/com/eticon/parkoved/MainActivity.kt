package com.eticon.parkoved

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var signInUser: ConstraintLayout
    lateinit var signInPersonal: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInPersonal = findViewById(R.id.sign_in_personal)
        signInUser = findViewById(R.id.sign_in_user)

        signInUser.setOnClickListener{

        }

        signInPersonal.setOnClickListener {

        }
    }
}