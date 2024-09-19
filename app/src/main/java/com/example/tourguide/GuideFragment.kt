package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// Fragment to display information about the selected city
class GuideFragment : Fragment() {

    // Declare the header and city info TextViews
    private lateinit var cityHeader : TextView
    private lateinit var cityInfo : TextView

    // Override onCreateView() to inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    // Override onViewCreated() to initialize the cityHeader and cityInfo TextViews
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cityHeader = view.findViewById(R.id.textViewHeader)
        cityInfo = view.findViewById(R.id.textViewCityInfo)

        // Check bundle for saved data to update cityHeader and cityInfo
        if (savedInstanceState != null) {
            cityHeader.text = savedInstanceState.getString("selectedCity")
            cityInfo.text = savedInstanceState.getString("cityDescription")
        } else {
            // If no saved data, set default values
            cityHeader.text = getString(R.string.header)
            cityInfo.text = getString(R.string.welcome)
        }
    }

    // Override onSaveInstanceState() to save selected city and city description to bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("selectedCity", cityHeader.text.toString())
        outState.putString("cityDescription", cityInfo.text.toString())
    }

    // Updates cityHeader and cityInfo based on the selected city
    fun updateGuide(city: String, cityDescription: String) {
        cityHeader.text = city
        cityInfo.text = cityDescription
    }
}