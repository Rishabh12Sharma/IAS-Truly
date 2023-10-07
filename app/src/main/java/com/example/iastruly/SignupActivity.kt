package com.example.iastruly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignupActivity : AppCompatActivity() {
    lateinit var login:Button
    lateinit var signup:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        login=findViewById(R.id.btn_login)
        login.setOnClickListener {
            val intent=Intent(this,ChaptersActivity::class.java)
            startActivity(intent)
        }
        signup=findViewById(R.id.txt_signingin)
        signup.setOnClickListener {
            val intent=Intent(this,SigninginActivity::class.java)
            startActivity(intent)
        }


    }
}