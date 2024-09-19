package com.example.tourguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var selectedCity: String
    private lateinit var cityDescription: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Check bundle for saved data
        if (savedInstanceState != null) {
            selectedCity = savedInstanceState.getString("selectedCity").toString()
            cityDescription = savedInstanceState.getString("cityDescription").toString()
        } else {
            selectedCity = getString(R.string.header)
            cityDescription = getString(R.string.welcome)
        }
    }

    // Override onSaveInstanceState to save selected city and city description to bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("selectedCity", selectedCity)
        outState.putString("cityDescription", cityDescription)
    }

    // Updates selected city
    fun updateSelectedCity(city: String) {
        selectedCity = city

        // Update the city info based on the selected city
        cityDescription = when (city) {
            "Calgary" -> getString(R.string.Calgary)
            "Victoria" -> getString(R.string.Victoria)
            "Vancouver" -> getString(R.string.Vancouver)
            "Toronto" -> getString(R.string.Toronto)
            "Halifax" -> getString(R.string.Halifax)
            "Montreal" -> getString(R.string.Montreal)
            "Fredericton" -> getString(R.string.Fredericton)
            else -> getString(R.string.welcome)
        }

        // Get a reference to GuideFragment
        val guideFragment = supportFragmentManager.findFragmentById(R.id.guideFragmentContainer) as GuideFragment
        guideFragment.updateGuide(selectedCity, cityDescription)
    }
}