package com.example.rssreader.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "websites")
public class Websites {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Websites(int id, String url) {
        this.id = id;
        this.url = url;
    }
}

