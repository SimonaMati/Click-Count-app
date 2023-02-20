package csc244.clickcountapp

/**************************
Class: CSC244
Student: Simona Matiukaite
***************************/

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.logging.LogRecord

class MainActivity : AppCompatActivity() {
    //Variables
    var number = 0
    var limitNumber = 5
    //Initializing variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Invoke the increasing/decreasing function with the default limit number
        increasingDecreasingNumber(limitNumber)

        val passedLimitNumber = intent.getIntExtra(NEW_LIMIT_BY_USER, 0)

        //Invoke the increasing/decreasing function with a user-set limit number
        if(passedLimitNumber > limitNumber || passedLimitNumber < limitNumber
            && !(passedLimitNumber == 0)){
            increasingDecreasingNumber(passedLimitNumber)
        }
    }

    fun increasingDecreasingNumber (limit:Int){
        var outcomeText = findViewById<TextView>(R.id.outcome)
        val view = View(this)

        //Increment the number
        val incrementButton = findViewById<Button>(R.id.increment_button)
        incrementButton.setOnClickListener{
            number++
            outcomeText.text = number.toString()

            if(number == limit){
                goToSecondActivity(view)
            }
        }

        //Decrement the number
        val decrementButton = findViewById<Button>(R.id.decrement_button)
        decrementButton.setOnClickListener {
            number--
            outcomeText.text = number.toString()

            if(number == limit){
                goToSecondActivity(view)
            }
        }

        //Reset the number value
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {

            number = 0
            outcomeText.text = number.toString()
        }
    }

    //Go to the Second Activity
    fun goToSecondActivity(view: View){
        val intent = Intent(this, SecondActivity::class.java).apply{
        }
        startActivity(intent)
    }
}