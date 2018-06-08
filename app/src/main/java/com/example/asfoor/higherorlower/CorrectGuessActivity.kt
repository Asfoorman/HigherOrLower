package com.example.asfoor.higherorlower

import android.os.Bundle
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_correct_guess.*

class CorrectGuessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct_guess)

        playAgain()
        exit()
    }

    fun playAgain(){
        bttnPlayAgain.setOnClickListener{
            val intent = Intent("com.example.asfoor.higherorlower.MainActivity")
            startActivity(intent)
        }
    }

    fun exit(){
        bttnExit.setOnClickListener{
            this.finishAffinity()
        }
    }

}