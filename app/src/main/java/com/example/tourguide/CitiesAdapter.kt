package com.example.tourguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

// Custom adapter to display cities in a ListView
class CitiesAdapter (context: Context, data: Array<String>) : ArrayAdapter<String>(context, 0, data) {

    // Override the getView() method to customize the layout for each list item
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the custom layout for the list item
        val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_custom, parent, false)
        val item = getItem(position)
        val cityName : TextView = itemView.findViewById(R.id.textViewListItem)
        cityName.text = item
        return itemView
    }
}