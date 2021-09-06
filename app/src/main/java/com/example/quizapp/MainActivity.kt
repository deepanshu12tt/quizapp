package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        button.setOnClickListener{
            if(inpput.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                var intent=Intent(this,questionactivity::class.java)
                intent.putExtra("${setdata.name}",inpput.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}