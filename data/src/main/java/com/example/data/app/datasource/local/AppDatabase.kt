package com.example.data.app.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.app.datasource.local.dao.AppDAO
import com.example.data.app.repository.model.Movie

@Database(
  entities = [Movie::class],
  version = 1,
  exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

  companion object {
    private const val DATABASE_NAME = "movie_database"

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun buildDatabase(context: Context): AppDatabase {
      val tempInstance = INSTANCE

      if (tempInstance != null) {
        return tempInstance
      }

      synchronized(this) {
        val instance = Room.databaseBuilder(
          context,
          AppDatabase::class.java,
          DATABASE_NAME
        ).build()

        INSTANCE = instance

        return instance
      }
    }
  }

  abstract val appDAO: AppDAO
}