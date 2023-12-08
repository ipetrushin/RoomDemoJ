package com.example.roomdemoj;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface Playlist {
    @Query("SELECT * FROM tunes ORDER BY title")
    List<Tune> selectAll();

    @Query("SELECT * FROM tunes WHERE year = 2021 ORDER BY title")
    List<Tune> selectThisYearTunes();

    @Query("SELECT * FROM tunes WHERE _id=:id")
    Tune findById(int id);

    @Insert
    void insert(Tune... tunes);

    @Delete
    void delete(Tune... tunes);

    @Update
    void update(Tune... tunes);
}
