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
    private int shelfModelId;

    @SerializedName("code")
    private String code;

    @SerializedName("location")
    private String location;

    @SerializedName("active")
    private boolean active;

    public ShelfModel(int shelfModelId, String code, String location, boolean active) {
        this.shelfModelId = shelfModelId;
        this.code = code;
        this.location = location;
        this.active = active;
    }

    public int getShelfModelId() {
        return shelfModelId;
    }

    public void setShelfModelId(int shelfModelId) {
        this.shelfModelId = shelfModelId;
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
