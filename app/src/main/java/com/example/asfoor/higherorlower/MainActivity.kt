package com.example.asfoor.higherorlower

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*


class MainActivity : AppCompatActivity() {

    var randomNum = 0 //global randomNum int this is the number that the user must guess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNum()
        createBttnListener()
    }

    fun generateRandomNum(): Int {
        var random = Random()
        var min = 1
        var max = 5

        randomNum = random.nextInt(max + 1 - min) + min

        return randomNum
    }

    fun assignRandomNum() {
        randomNum = generateRandomNum()
    }

    fun guessNum() {

        var numToGuess = randomNum
        var usrGuess: Int = Integer.parseInt(guessNum.getText().toString())

        checkUsrGuess(usrGuess, numToGuess) //guess the number by calling function and passing in the guess and the correct number
    }

    fun checkUsrGuess(usrGuess: Int, numToGuess: Int) {

        if(usrGuess > numToGuess) {
            lblFdbck.setText("Lower Lovie, Try Again!")
        } else if (usrGuess < numToGuess) {
            lblFdbck.setText("Higher Hombre, Try Again!!")
        } else {
            lblFdbck.setText("COMMANDER YOU ALL CORRECT #ALLCAPS!!")

            openCongratScreen()
        }
    }

    fun createBttnListener(){
        guessBttn.setOnClickListener{
            if(guessNum.getText().toString().equals("")){
                toast("Peasant Please Enter a Number!")
            }   else {
                guessNum()
            }
        }
    }

    fun openCongratScreen() {
        val intent = Intent("com.example.asfoor.higherorlower.CorrectGuessActivity")
        startActivity(intent)
    }



}
