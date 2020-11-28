package com.example.uielements

import android.R.layout.activity_list_item
import android.R.layout.simple_list_item_activated_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class Songs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)
        val songsArray = arrayOf("Living in a Ghost Town","You Should Be Sad" ,"Imported","In In In","Slide","Blueberry Faygo","Toosie Slide","My Truch","You're Too Precious","Tusa","Let Me Know","Dealer","Intentions","Charlie","Aries","RockStar","Good Bad Times")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songsArray)
        val songListView = findViewById<ListView>(R.id.songlv)
        songListView.adapter = adapter
        songListView.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
            Log.i("Position","Position $position")

        }

    }
}