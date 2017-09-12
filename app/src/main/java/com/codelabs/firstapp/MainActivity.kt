package com.codelabs.firstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("username", main_edittext_nama.text.toString())
        intent.putExtra("password", main_edittext_password.text.toString())
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button_login.setOnClickListener(this)
    }
}
