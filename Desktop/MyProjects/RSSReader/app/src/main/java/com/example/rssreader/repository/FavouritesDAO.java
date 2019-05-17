package com.example.rssreader.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rssreader.Models.Article;

import java.util.List;

@Dao
public interface FavouritesDAO {
    @Query("SELECT * FROM favourites where id = :id")
    LiveData<List<Article>> getItems (Long id);

    @Insert
    long insertItem(Article article);

    @Update
    int updateItem(Article article);

    @Query("DELETE FROM favourites WHERE id = :id")
    int deleteItem(long id);
}
