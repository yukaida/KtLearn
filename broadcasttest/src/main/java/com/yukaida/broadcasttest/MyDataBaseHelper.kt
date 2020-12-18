package com.yukaida.broadcasttest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.contentValuesOf

class MyDataBaseHelper(private val context: Context, version:Int):SQLiteOpenHelper(context,"ktTestDB.db",null,version) {
    private val strCreateTable="create table Book(id integer primary key autoincrement,author text,price integer,pages integer,name text)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(strCreateTable)
        Toast.makeText(context, "DB create success", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}