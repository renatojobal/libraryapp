package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ShelfModel {
    /**
     * Shelf model
     */

    @PrimaryKey
    private int id;

    private int code;

    private String location;

    private boolean active;

    public ShelfModel(int id, int code, String location, boolean active) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.code = code;
        this.location = location;
        this.active = active;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
