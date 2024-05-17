package com.example.runandtrack.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.runandtrack.data.models.Run

@Database(entities = [Run::class], version = 1)
@TypeConverters(Convertors::class)
abstract class RunningDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDAO

}