package com.example.iastruly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SigninginActivity : AppCompatActivity() {
    lateinit var btn_signin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_signin=findViewById(R.id.btn_register)
        btn_signin.setOnClickListener {
            val intent=Intent(this,ChaptersActivity::class.java)
            startActivity(intent)
        }

    }
}