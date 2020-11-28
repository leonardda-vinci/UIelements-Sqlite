package com.example.uielements

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DatabaseHandler.DB_NAME, null, DatabaseHandler.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
                TITLE + " INTEGER PRIMARY KEY," +
                ARTIST + " TEXT," + ALBUM + " TEXT," +
                RELEASEDATE + " TEXT);"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addTask(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TITLE, tasks.title)
        values.put(ARTIST, tasks.artist)
        values.put(ALBUM, tasks.album)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    fun getTask(_id: Int): Tasks {
        val tasks = Tasks()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $TITLE = $_id"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            cursor.moveToFirst()
            while (cursor.moveToNext()) {
                tasks.title = cursor.getString(cursor.getColumnIndex(TITLE))
                tasks.artist = cursor.getString(cursor.getColumnIndex(ARTIST))
                tasks.album = cursor.getString(cursor.getColumnIndex(ALBUM))
                tasks.releasedate = cursor.getString(cursor.getColumnIndex(RELEASEDATE))
            }
        }
        cursor.close()
        return tasks
    }

    val task: List<Tasks>
        get() {
            val taskList = ArrayList<Tasks>()
            val db = writableDatabase
            val selectQuery = "SELECT  * FROM $TABLE_NAME"
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor != null) {
                cursor.moveToFirst()
                while (cursor.moveToNext()) {
                    val tasks = Tasks()
                    tasks.title = cursor.getString(cursor.getColumnIndex(TITLE))
                    tasks.artist = cursor.getString(cursor.getColumnIndex(ARTIST))
                    tasks.album = cursor.getString(cursor.getColumnIndex(ALBUM))
                    tasks.releasedate = cursor.getString(cursor.getColumnIndex(RELEASEDATE))
                    taskList.add(tasks)
                }
            }
            cursor.close()
            return taskList
        }

    fun updateTask(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TITLE, tasks.title)
        values.put(ARTIST, tasks.artist)
        values.put(ALBUM, tasks.album)
        val _success = db.update(TABLE_NAME, values, TITLE + "=?", arrayOf(tasks.title.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteTask(_id: Int): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, TITLE + "=?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    companion object {
            private val DB_VERSION = 1
            private val DB_NAME = "MyTasks"
            private val TABLE_NAME = "Tasks"
            private val TITLE = "title"
            private val ARTIST = "artist"
            private val ALBUM = "album"
            private val RELEASEDATE = "releasedate"

    }
    class Tasks {
        var title = "title"
        var artist = "artist"
        var album = "album"
        var releasedate = "releasedate"
    }
}


