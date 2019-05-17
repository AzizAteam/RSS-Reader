package com.example.rssreader.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rssreader.Models.Article;

import java.util.List;

import retrofit2.http.Url;

@Dao
public interface WebsitesDAO {
    @Query("SELECT * FROM websites where id = :id")
    LiveData<List<Url>> getItem (Long id);

    @Insert
    long insertItem(Url url);

    @Update
    int updateItem(Url url);

    @Query("DELETE FROM websites WHERE id = :id")
    int deleteItem(long id);
}
