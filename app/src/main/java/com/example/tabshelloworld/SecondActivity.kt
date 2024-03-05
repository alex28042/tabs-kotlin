package com.example.tabshelloworld

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import java.io.IOException


class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.getBundleExtra("locationBundle")
        val location: Location? = bundle?.getParcelable("location")
        Log.d("Message", "onCreate: The activity is being created. Second");

        val buttonNext: Button = findViewById(R.id.buttonD2)
        buttonNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }


        val buttonBack: Button = findViewById(R.id.buttonA1)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if (location != null) {
            val textView: TextView = findViewById(R.id.secondTextView)
            textView.text = "Latitude: ${location.latitude}, Longitude: ${location.longitude}"
        }
    }
}