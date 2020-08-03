package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * Shelf model
 */
@Entity(tableName = DBConstants.SHELF_TABLE)
public class ShelfModel {


    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = DBConstants.SHELF_ID)
    private int shelfModelId;

    @SerializedName("code")
    @ColumnInfo(name = DBConstants.SHELF_CODE)
    private String code;

    @SerializedName("location")
    @ColumnInfo(name = DBConstants.SHELF_LOCATION)
    private String location;

    @SerializedName("active")
    @ColumnInfo(name = DBConstants.SHELF_ACTIVE)
    private boolean active;

    /**
     * Full params constructor
     * @param shelfModelId
     * @param code
     * @param location
     * @param active
     */
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

    @Override
    public String toString() {
        return "ShelfModel{" +
                "shelfModelId=" + shelfModelId +
                ", code='" + code + '\'' +
                ", location='" + location + '\'' +
                ", active=" + active +
                '}';
    }
}
