package csc244.clickcountapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

const val NEW_LIMIT_BY_USER = "csc244.switchingactivity.NEW_LIMIT_NUMBER"

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Initializing variables
        val view = View(this)
        val setButton = findViewById<Button>(R.id.setButton)

        //On Set button click
        setButton.setOnClickListener {
            goToMainActivity(view)
        }
    }

    //Take the new limit number to the Main Activity
    fun goToMainActivity(view:View){
        val userLimitNumber = findViewById<EditText>(R.id.userLimitNumber)
        val newNumber = userLimitNumber.text.toString().toInt()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(NEW_LIMIT_BY_USER, newNumber)
        }
        startActivity(intent)
    }
}