package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class ShelfModel {
    /**
     * Shelf model
     */

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("code")
    private String code;

    @SerializedName("location")
    private String location;

    @SerializedName("active")
    private boolean active;

    public ShelfModel(int id, String code, String location, boolean active) {
        this.id = id;
        this.code = code;
        this.location = location;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
