package com.example.data.app.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.app.repository.model.Movie

@Dao
interface AppDAO {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertMovie(movie: Movie)

  @Query("SELECT * FROM movie")
  fun getMovies(): List<Movie>?
}