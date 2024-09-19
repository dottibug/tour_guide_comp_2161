package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

// Fragment to display a list of cities to select. Clicking a city displays its description in
// the GuideFragment
class CitiesFragment : Fragment() {

    // Override onCreateView() to inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    // Override onViewCreated() to initialize the cities ListView, set up the custom
    // CitiesAdapter, and set up the click listener for the cities ListView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (super.onViewCreated(view, savedInstanceState))

        // Create an array of cities and set up the custom CitiesAdapter
        val citiesList : ListView = view.findViewById(R.id.citiesListView)
        val cities : Array<String> = resources.getStringArray(R.array.cities)
        val adapter = CitiesAdapter(requireContext(), cities)
        citiesList.adapter = adapter

        // Click listener for the cities ListView
        citiesList.setOnItemClickListener { parent, view, position, id ->
            val selectedCity = cities[position]
            // Pass selected city to MainActivity to update the GuideFragment
            val activity = requireActivity() as MainActivity
            activity.updateSelectedCity(selectedCity)
        }
    }
}