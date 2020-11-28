package com.example.uielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class image3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image3)
        val songsArray = arrayOf(
            "Kabilang Buhay",
            "Holy",
            "Mood",
            "Godzilla",
            "Intentions",
            "Charlie",
            "Aries",
            "RockStar",
            "Good Bad Times" )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songListView = findViewById<ListView>(R.id.songlv1)
        songListView.adapter = adapter
    }
}