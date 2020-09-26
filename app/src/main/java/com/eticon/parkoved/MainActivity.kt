package com.eticon.parkoved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.eticon.parkoved.Personal.PersonalNavigator

class MainActivity : AppCompatActivity() {

    lateinit var signInUser: ConstraintLayout
    lateinit var signInPersonal: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInPersonal = findViewById(R.id.sign_in_personal)
        signInUser = findViewById(R.id.sign_in_user)

        signInUser.setOnClickListener{
            var intent = Intent(this, CaseParkActivity::class.java)
            startActivity(intent)
            finish()
        }

        signInPersonal.setOnClickListener {
            var intent = Intent(this , PersonalNavigator::class.java)
            startActivity(intent)
            finish()
        }
    }
}