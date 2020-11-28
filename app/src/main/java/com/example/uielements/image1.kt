package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView

class image1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image1)
        val songsArray = arrayOf(
            "Kabilang Buhay",
            "Holy",
            "Mood",
            "Godzilla",
            "Mistletoe",
            "Beautiful Scars",
            "Intentions",
            "Mean it",
            "I'm the one",
            "Goodbyes",

        )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songListView = findViewById<ListView>(R.id.songlv1)
        songListView.adapter = adapter
    }


    }
